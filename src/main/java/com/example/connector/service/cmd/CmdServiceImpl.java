package com.example.connector.service.cmd;

import com.example.connector.bo.device.DeviceBo;
import com.example.connector.gateway.device.DeviceGateway;
import com.example.connector.gateway.device.DeviceGatewayImpl;
import com.example.connector.go.device.ClientGo;
import com.example.connector.go.device.RequestGo;
import com.example.connector.go.device.ResponseGo;
import com.example.connector.service.charger.ChargerServiceBiz;
import com.example.connector.service.chiller.ChillerServiceBiz;
import com.example.connector.service.device.DeviceServiceBiz;
import com.example.connector.service.gw.GwServiceBiz;
import com.example.connector.service.kg.KgServiceBiz;
import com.example.connector.util.TimeUtil;
import com.example.connector.vo.cmd.ChargerControlVo;
import com.example.connector.vo.cmd.ChillerControlVo;
import com.example.connector.vo.cmd.DeviceInfoPullVo;
import com.example.connector.vo.cmd.DeviceRunDataPullVo;
import com.example.connector.vo.cmd.KgControlVo;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CmdServiceImpl implements CmdService {
    private static final Gson gson = new Gson();

    @Data
    @AllArgsConstructor
    class Response {
        byte status;
        String data;
    }

    abstract class ClientRequestHandlerBase {
        protected final Gson gson = new Gson();

        public abstract short getType();

        public abstract Response handle(ClientGo client, long time, String data);
    }

    class Type0004ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 0x0004;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("心跳，data：{}", data);
            HeartbeatCommonRequest r = gson.fromJson(data, HeartbeatCommonRequest.class);

            return new Response((byte) 0, String.format("{\"msg\": \"%s\"}", r.getMsg()));
        }
    }

    /** 负控设备静态数据上传 */
    class Type1001ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 0x1001;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("负控设备静态数据上传，data：{}", data);
            KgInfoUpdateClientRequest r = gson.fromJson(data, KgInfoUpdateClientRequest.class);

            kgService.updateDeviceInfo(r.getBo(client.getId()));

            return new Response((byte) 0, "{}");
        }
    }

    /** 充电桩设备静态数据上传 */
    class Type1002ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 1002;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("收到充电桩静态静态数据上传，data：{}", data);

            ChargerInfoUpdateClientRequest r =
                    gson.fromJson(data, ChargerInfoUpdateClientRequest.class);

            chargerService.updateDeviceInfo(r.getBo(client.getId()));

            return new Response((byte) 0, "{}");
        }
    }

    /** 中央空调设备静态数据上传 */
    class Type1003ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 1003;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("中央空调设备静态数据上传，data：", data);
            ChillerInfoUpdateClientRequest r =
                    gson.fromJson(data, ChillerInfoUpdateClientRequest.class);

            chillerService.updateDeviceInfo(r.getBo(client.getId()));

            return new Response((byte) 0, "{}");
        }
    }

    /** 网关设备静态数据上传 */
    class Type1004ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 1004;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("网关设备静态数据上传，data：{}", data);
            GwInfoUpdateClientRequest r = gson.fromJson(data, GwInfoUpdateClientRequest.class);

            gwService.updateDeviceInfo(r.getBo(client.getId()));

            return new Response((byte) 0, "{}");
        }
    }

    /** 负控设备运行数据上传 */
    class Type2001ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 2001;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("负控设备运行数据上传，data：{}", data);
            KgRunDataUploadClientRequest r =
                    gson.fromJson(data, KgRunDataUploadClientRequest.class);

            kgService.addRunElectricityData(r.getElectricityBo(client.getId(), time));
            kgService.addRunOtherData(r.getOtherBo(client.getId(), time));
            kgService.addRunPowerData(r.getPowerBo(client.getId(), time));
            kgService.addRunStateData(r.getStateBo(client.getId(), time));

            return new Response((byte) 0, "{}");
        }
    }

    /** 充电桩设备运行数据上传 */
    class Type2002ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 2002;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("充电桩设备运行数据上传，data：{}", data);

            ChargerRunDataUploadClientRequest r =
                    gson.fromJson(data, ChargerRunDataUploadClientRequest.class);

            chargerService.addRunEnergyData(r.getEnergyBo(client.getId(), time));
            chargerService.addRunOtherData(r.getOtherBo(client.getId(), time));
            chargerService.addRunPowerData(r.getPowerBo(client.getId(), time));
            chargerService.addRunStateData(r.getStateBo(client.getId(), time));

            return new Response((byte) 0, "{}");
        }
    }

    /** 中央空调设备运行数据上传 */
    class Type2003ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 2003;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("中央空调设备运行数据上传，data：{}", data);

            var r = gson.fromJson(data, ChillerRunDataUploadClientRequest.class);

            chillerService.addRunStateData(r.getStateBo(client.getId(), time));
            chillerService.addRunPowerData(r.getPowerBo(client.getId(), time));
            chillerService.addRunData(r.getOtherBo(client.getId(), time));

            return new Response((byte) 0, "{}");
        }
    }

    /** 充电桩设备充电交易数据上传 */
    class Type2004ClientHandler extends ClientRequestHandlerBase {
        @Override
        public short getType() {
            return 2004;
        }

        @Override
        public Response handle(ClientGo client, long time, String data) {
            log.info("充电桩设备充电交易数据上传，data：{}", data);

            ChargerTransactionInfoClientRequest r =
                    gson.fromJson(data, ChargerTransactionInfoClientRequest.class);

            chargerService.addRunElectricityData(r.getElectricityBo(client.getId(), time));

            return new Response((byte) 0, "{}");
        }
    }

    @Autowired DeviceServiceBiz deviceService;
    @Autowired GwServiceBiz gwService;
    @Autowired KgServiceBiz kgService;
    @Autowired ChillerServiceBiz chillerService;
    @Autowired ChargerServiceBiz chargerService;

    DeviceGateway deviceGateway = new DeviceGatewayImpl();

    @PostConstruct
    void init() {
        List<ClientGo> clients =
                deviceService.getAllDeviceBos().stream()
                        .map(d -> new ClientGo(d.getId(), d.getGatewayId(), d.getAddr()))
                        .collect(Collectors.toList());

        deviceGateway.init(clients);
        deviceGateway.registerSignUpHandler(
                c ->
                        deviceService.createDevice(
                                new DeviceBo(c.getId(), c.getGatewayId(), c.getAddr())));
        deviceGateway.registerSignInHandler(c -> {});

        List<ClientRequestHandlerBase> handlers =
                Arrays.asList(
                        new Type0004ClientHandler(),
                        new Type1001ClientHandler(),
                        new Type1002ClientHandler(),
                        new Type1003ClientHandler(),
                        new Type1004ClientHandler(),
                        new Type2001ClientHandler(),
                        new Type2002ClientHandler(),
                        new Type2003ClientHandler(),
                        new Type2004ClientHandler());
        for (var handler : handlers)
            deviceGateway.registerRequestHandler(
                    handler.getType(),
                    (client, request) -> {
                        try {
                            var r = handler.handle(client, request.getTime(), request.getData());
                            return new ResponseGo(
                                    TimeUtil.nowUnixTimeStamp(), r.getStatus(), r.getData());
                        } catch (Exception e) {
                            e.printStackTrace();
                            return new ResponseGo(
                                    TimeUtil.nowUnixTimeStamp(),
                                    (byte) 0x08,
                                    String.format("{\"msg\": \"%s\"}", e.toString()));
                        }
                    });
    }

    @Override
    public Long addDeviceInfoUpdateCmd(DeviceInfoPullVo vo) {
        final short type = 0x1001;

        DeviceInfoPullServerRequest r = new DeviceInfoPullServerRequest();

        deviceGateway.send(
                vo.getClientId(),
                new RequestGo(TimeUtil.nowUnixTimeStamp(), type, gson.toJson(r)),
                response -> {});

        return 0l;
    }

    // 添加获取设备运行数据的命令
    @Override
    public Long addDeviceRunDataCmd(DeviceRunDataPullVo vo) {
        final short type = 0x2001;

        DeviceRunDataPullServerRequest r = new DeviceRunDataPullServerRequest(vo);

        deviceGateway.send(
                vo.getClientId(),
                new RequestGo(TimeUtil.nowUnixTimeStamp(), type, gson.toJson(r)),
                resposne -> {});

        return 0l;
    }

    // 发送负控设备控制命令
    @Override
    public Long addKgControlCmd(KgControlVo vo) {
        final short type = 0x3001;

        KgControlServerRequest r = new KgControlServerRequest(vo);

        deviceGateway.send(
                vo.getClientId(),
                new RequestGo(TimeUtil.nowUnixTimeStamp(), type, gson.toJson(r)),
                response -> {});

        return 0l;
    }

    // 发送充电桩设备控制命令
    @Override
    public Long addChargerControlCmd(ChargerControlVo vo) {
        final short type = 0x3002;

        ChargerControlServerRequest r = new ChargerControlServerRequest(vo);

        deviceGateway.send(
                vo.getClientId(),
                new RequestGo(TimeUtil.nowUnixTimeStamp(), type, gson.toJson(r)),
                response -> {});

        return 0l;
    }

    // 发送冷机设备控制命令
    @Override
    public Long addChillerControlCmd(ChillerControlVo vo) {
        final short type = 0x3003;

        ChillerControlServerRequest r = new ChillerControlServerRequest(vo);

        deviceGateway.send(
                vo.getClientId(),
                new RequestGo(TimeUtil.nowUnixTimeStamp(), type, gson.toJson(r)),
                response -> {});

        return 0l;
    }

    /** for test usage */
    public void setDeviceGateway(DeviceGateway gateway) {
        this.deviceGateway = gateway;
    }
}
