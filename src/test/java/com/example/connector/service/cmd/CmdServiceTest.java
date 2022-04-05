package com.example.connector.service.cmd;

import com.example.connector.gateway.device.DeviceGateway;
import com.example.connector.util.TimeUtil;
import com.example.connector.vo.cmd.*;
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

    @Test
    void addDeviceRunDataCmd() {
        DeviceRunDataPullVo vo = new DeviceRunDataPullVo(0, TimeUtil.nowUnixTimeStamp());

        service.addDeviceRunDataCmd(vo);
        Mockito.verify(deviceGateway, Mockito.atLeastOnce())
                .send(Mockito.eq(vo.getClientId()), Mockito.any(), Mockito.any());
    }

    @Test
    void addKgControlCmd() {
        KgControlVo vo = new KgControlVo();
        vo.setClientId(1);

        service.addKgControlCmd(vo);
        Mockito.verify(deviceGateway, Mockito.atLeastOnce())
                .send(Mockito.eq(vo.getClientId()), Mockito.any(), Mockito.any());
    }

    @Test
    void addChargerControlCmd() {
        ChargerControlVo vo = new ChargerControlVo();
        vo.setClientId(2);

        service.addChargerControlCmd(vo);
        Mockito.verify(deviceGateway, Mockito.atLeastOnce())
                .send(Mockito.eq(vo.getClientId()), Mockito.any(), Mockito.any());
    }

    @Test
    void addChillerControlCmd() {
        ChillerControlVo vo = new ChillerControlVo();
        vo.setClientId(2);

        service.addChillerControlCmd(vo);
        Mockito.verify(deviceGateway, Mockito.atLeastOnce())
                .send(Mockito.eq(vo.getClientId()), Mockito.any(), Mockito.any());
    }
}
