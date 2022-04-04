package com.example.connector.service.cmd;

import com.example.connector.gateway.device.DeviceGateway;
import com.example.connector.vo.cmd.DeviceInfoPullVo;
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
        DeviceInfoPullVo vo = new DeviceInfoPullVo();
        vo.setClientId(0);

        service.addDeviceInfoUpdateCmd(vo);
        Mockito.verify(deviceGateway, Mockito.atLeastOnce())
                .send(Mockito.eq(vo.getClientId()), Mockito.any(), Mockito.any());
    }
}
