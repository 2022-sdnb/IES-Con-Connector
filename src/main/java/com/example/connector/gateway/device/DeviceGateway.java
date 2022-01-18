package com.example.connector.gateway.device;

import com.example.connector.go.device.ClientGo;
import com.example.connector.go.device.RequestGo;
import com.example.connector.go.device.ResponseGo;
import java.net.SocketAddress;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public interface DeviceGateway {
    void init(List<ClientGo> clients);

    List<SocketAddress> getAllAddrs();

    void registerRequestHandler(short type, BiFunction<ClientGo, RequestGo, ResponseGo> function);

    void registerSignUpHandler(Consumer<ClientGo> consumer);

    void registerSignInHandler(Consumer<ClientGo> consumer);

    void send(long clientId, RequestGo request, Consumer<ResponseGo> consumer);
}
