package com.example.connector.service.cmd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.gateway.device.DeviceGateway;
import com.example.connector.go.device.RequestGo;
import com.example.connector.go.device.ResponseGo;
import com.example.connector.util.TimeUtil;
import com.example.connector.vo.cmd.DeviceInfoPullVo;
import com.google.gson.Gson;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CmdServiceTest {

    @Autowired CmdService service;

    @MockBean DeviceGateway deviceGateway;

    @Test
    void addDeviceInfoUpdateCmd() {
        final short type = 0x1001;

        DeviceInfoPullServerRequest r = new DeviceInfoPullServerRequest();
        Gson gson = new Gson();

        DeviceInfoPullVo vo = new DeviceInfoPullVo();
        vo.setClientId(0);

        RequestGo requestGo = new RequestGo(TimeUtil.nowUnixTimeStamp(), type, gson.toJson(r));

        Consumer<ResponseGo> consumer =
                new Consumer<ResponseGo>() {
                    @Override
                    public void accept(ResponseGo responseGo) {}
                };

        service.addDeviceInfoUpdateCmd(vo);
        Mockito.verify(deviceGateway, Mockito.atLeastOnce())
                .send(vo.getClientId(), requestGo, consumer);

        assertTrue(true);
    }
}
