package com.example.connector.gateway.device;

import com.example.connector.go.device.ClientGo;
import com.example.connector.go.device.RequestGo;
import com.example.connector.go.device.ResponseGo;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceGatewayImpl implements DeviceGateway {
    private static final int PORT = 8082;
    private static final short API_VERSION = 0x0002;
    private static final short MAX_CMD_ID = 0x7fff;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class ClientTokenCmdIdPair {
        ClientToken token;
        short cmdId;
    }

    ServerSocket serverSocket;

    /** Client token 计数器 */
    long clientTokenCounter = 0;

    /** 映射当前连接的所有 client token 到 InetSocketAddress */
    final ConcurrentMap<ClientToken, SocketAddress> addrMap = new ConcurrentHashMap<>();

    /** 接收到的请求 */
    final ConcurrentLinkedQueue<Request> requestRx = new ConcurrentLinkedQueue<>();

    /** 接收到的响应 */
    final ConcurrentLinkedQueue<Response> responseRx = new ConcurrentLinkedQueue<>();

    /** 接收到的注册请求 */
    final ConcurrentLinkedQueue<SignUpRequest> signUpRequestRx = new ConcurrentLinkedQueue<>();

    /** 接收到的登录请求 */
    final ConcurrentLinkedQueue<SignInRequest> signInRequestRx = new ConcurrentLinkedQueue<>();

    /** 目前断开连接的客户端的 token */
    final ConcurrentLinkedQueue<ClientToken> disconnectionRx = new ConcurrentLinkedQueue<>();

    /** 注册的请求处理器 */
    final Map<Short, BiFunction<ClientGo, RequestGo, ResponseGo>> requestHandlerMap =
            new HashMap<>();

    /** Client ID 计数器 */
    long clientIdCounter;

    /** 所有已注册的客户端 */
    final Set<ClientGo> signedUpClientSet = new HashSet<>();

    /** 客户端 ID 到 token 的映射 */
    final Map<Long, ClientToken> clientTokenMap = new HashMap<>();

    /** 客户端 ID 到网关 ID 的映射 */
    final Map<Long, Long> gatewayIdMap = new HashMap<>();

    /** Token 到客户端的映射 */
    final Map<ClientToken, ClientGo> clientMap = new HashMap<>();

    /** 注册请求处理器 */
    Consumer<ClientGo> signUpRequestHandler;

    /** 登录请求处理器 */
    Consumer<ClientGo> signInRequestHandler;

    short cmdIdCounter = 0;

    /** 需要向客户端发送的请求 */
    final ConcurrentMap<ClientToken, ConcurrentLinkedQueue<Request>> requestTxMap =
            new ConcurrentHashMap<>();

    /** 需要向客户端发送的响应 */
    final ConcurrentMap<ClientToken, ConcurrentLinkedQueue<Response>> responseTxMap =
            new ConcurrentHashMap<>();

    /** 需要向客户端发送的注册响应 */
    final ConcurrentMap<ClientToken, ConcurrentLinkedQueue<SignUpResponse>> signUpResponseTxMap =
            new ConcurrentHashMap<>();

    /** 需要向客户端发送的登陆响应 */
    final ConcurrentMap<ClientToken, ConcurrentLinkedQueue<SignInResponse>> signInResponseTxMap =
            new ConcurrentHashMap<>();

    /** 目前所有的响应处理器 */
    final Map<ClientTokenCmdIdPair, Consumer<ResponseGo>> responseHandlerMap = new HashMap<>();

    public void init(List<ClientGo> clients) {
        long maxClientId = 0;
        for (var client : clients) maxClientId = Math.max(maxClientId, client.getId());
        signedUpClientSet.addAll(clients);
        clientIdCounter = maxClientId + 1;

        try {
            serverSocket = new ServerSocket(PORT);
            // 设置为非阻塞，会影响 accept，read
            serverSocket.setSoTimeout(100);
            log.info("服务端 socket 启动成功, 端口号: {}", serverSocket.getLocalPort());
        } catch (IOException e) {
            log.error("服务端 socket 启动失败", e);
            return;
        }

        Thread serverThread =
                new Thread(
                        () -> {
                            while (true) {
                                acceptClient();

                                receiveMsg();

                                handleDisconnectedAddr();
                            }
                        });
        serverThread.setDaemon(true);
        serverThread.start();
    }

    @Override
    public List<SocketAddress> getAllAddrs() {
        return addrMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void registerRequestHandler(
            short type, BiFunction<ClientGo, RequestGo, ResponseGo> function) {
        requestHandlerMap.put(type, function);
    }

    @Override
    public void registerSignUpHandler(Consumer<ClientGo> consumer) {
        signUpRequestHandler = consumer;
    }

    @Override
    public void registerSignInHandler(Consumer<ClientGo> consumer) {
        signInRequestHandler = consumer;
    }

    @Override
    public void send(long clientId, RequestGo request, Consumer<ResponseGo> consumer) {
        final short cmdId = cmdIdCounter++;
        if (cmdIdCounter > MAX_CMD_ID) cmdIdCounter = 1;

        var tk = clientTokenMap.get(clientId);
        var gatewayId = gatewayIdMap.get(clientId);

        ConcurrentLinkedQueue<Request> tx;
        if ((tx = requestTxMap.get(tk)) != null) {
            tx.add(new Request(tk, clientId, gatewayId, cmdId, request));
            responseHandlerMap.put(new ClientTokenCmdIdPair(tk, cmdId), consumer);
        } else {
            log.warn("找不到客户端，client ID：{}", clientId);
        }
    }

    /** 尝试连接 */
    private void acceptClient() {
        try {
            Socket socket = serverSocket.accept();
            var addr = socket.getInetAddress();
            var port = socket.getPort();
            var socketAddr = new InetSocketAddress(addr, port);

            log.info("客户端连接建立, {}", socketAddr);

            var tk = new ClientToken(clientTokenCounter++);
            addrMap.put(tk, socketAddr);

            ConcurrentLinkedQueue<Request> requestTx = new ConcurrentLinkedQueue<>();
            ConcurrentLinkedQueue<Response> responseTx = new ConcurrentLinkedQueue<>();
            ConcurrentLinkedQueue<SignUpResponse> signUpResponseTx = new ConcurrentLinkedQueue<>();
            ConcurrentLinkedQueue<SignInResponse> signInResponseTx = new ConcurrentLinkedQueue<>();
            requestTxMap.put(tk, requestTx);
            responseTxMap.put(tk, responseTx);
            signUpResponseTxMap.put(tk, signUpResponseTx);
            signInResponseTxMap.put(tk, signInResponseTx);

            AtomicBoolean connected = new AtomicBoolean(true);

            new MsgReceiver(
                            API_VERSION,
                            connected,
                            socket,
                            tk,
                            socketAddr,
                            requestRx,
                            responseRx,
                            signUpRequestRx,
                            signInRequestRx,
                            disconnectionRx)
                    .run();
            new MsgSender(
                            API_VERSION,
                            connected,
                            socket,
                            tk,
                            requestTx,
                            responseTx,
                            signUpResponseTx,
                            signInResponseTx)
                    .run();

        } catch (SocketTimeoutException e) {
            // 非阻塞式 accept，超时不需要处理
        } catch (IOException e) {
            log.warn("客户端连接失败", e);
        }
    }

    /** 获取接收到的 Msg 并调用回调 */
    private void receiveMsg() {
        Request request;
        while ((request = requestRx.poll()) != null) {
            var client = clientMap.get(request.tk);

            var handler = requestHandlerMap.get(request.go.getType());
            var response = handler.apply(client, request.go);
            ConcurrentLinkedQueue<Response> tx;
            if ((tx = responseTxMap.get(request.tk)) != null)
                tx.add(new Response(request.tk, request.cmdId, response));
            else log.warn("响应发送失败，客户端断线，client ID：{}", client.getId());
        }

        Response response;
        while ((response = responseRx.poll()) != null) {
            var handler =
                    responseHandlerMap.remove(
                            new ClientTokenCmdIdPair(response.tk, response.cmdId));
            if (handler != null) handler.accept(response.go);
        }

        SignUpRequest signUpRequest;
        while ((signUpRequest = signUpRequestRx.poll()) != null) {
            var tk = signUpRequest.tk;
            long clientId = clientIdCounter++;
            var client = new ClientGo(clientId, signUpRequest.gatewayId, signUpRequest.addr);

            signUpResponseTxMap
                    .get(tk)
                    .add(new SignUpResponse(tk, signUpRequest.cmdId, clientId, (byte) 0));

            signedUpClientSet.add(client);
            signUpRequestHandler.accept(client);

            log.info("注册成功，client ID：{}", clientId);
        }

        SignInRequest signInRequest;
        while ((signInRequest = signInRequestRx.poll()) != null) {
            var tk = signInRequest.tk;
            var client =
                    new ClientGo(
                            signInRequest.clientId, signInRequest.gatewayId, signInRequest.addr);
            if (signedUpClientSet.contains(client)) {
                signInResponseTxMap
                        .get(tk)
                        .add(new SignInResponse(tk, signInRequest.cmdId, (byte) 0));

                clientMap.put(tk, client);
                clientTokenMap.put(client.getId(), tk);
                gatewayIdMap.put(client.getId(), client.getGatewayId());

                signInRequestHandler.accept(client);

                log.info("登录成功，client ID：{}", signInRequest.clientId);
            } else {
                log.warn("登录失败，无此 ID，client ID：{}", signInRequest.clientId);
            }
        }
    }

    /** 处理连接断开 */
    private void handleDisconnectedAddr() {
        ClientToken tk;
        while ((tk = disconnectionRx.poll()) != null) {
            addrMap.remove(tk);
            requestTxMap.remove(tk);
            responseTxMap.remove(tk);
            signUpResponseTxMap.remove(tk);
            signInResponseTxMap.remove(tk);

            var client = clientMap.remove(tk);
            if (client != null) {
                clientTokenMap.remove(client.getId());
                gatewayIdMap.remove(client.getId());
            }
        }
    }
}
