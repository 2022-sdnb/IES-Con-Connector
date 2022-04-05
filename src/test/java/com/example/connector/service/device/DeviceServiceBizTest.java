package com.example.connector.service.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.bo.device.DeviceBo;
import com.example.connector.entity.device.Device;
import com.example.connector.repo.device.DeviceRepo;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DeviceServiceBizTest {

    private final List<Device> devices =
            Arrays.asList(
                    new Device(1L, 1L, "0.0.0.0", 1),
                    new Device(2L, 2L, "0.0.0.0", 2),
                    new Device(3L, 3L, "0.0.0.0", 3),
                    new Device(4L, 4L, "0.0.0.0", 4));

    private List<DeviceBo> deviceBos =
            devices.stream().map(DeviceBo::new).collect(Collectors.toList());

    @Autowired private DeviceServiceBiz serviceBiz;

    @MockBean private DeviceRepo repo;

    @Test
    void createDevice() {
        DeviceBo crt = new DeviceBo(1, 2, new InetSocketAddress("0.0.0.0", 22));

        Mockito.when(repo.save(crt.getEntity())).thenReturn(crt.getEntity());

        serviceBiz.createDevice(crt);

        Mockito.verify(repo, Mockito.atLeastOnce()).save(crt.getEntity());
        assertTrue(true);
    }

    @Test
    void getAllDeviceBos() {
        Mockito.when(repo.findAll()).thenReturn(devices);

        List<DeviceBo> actualBos = serviceBiz.getAllDeviceBos();
        for (int i = 0; i < deviceBos.size(); i++) {
            assertTrue(i < actualBos.size());
            assertEquals(deviceBos.get(i), actualBos.get(i));
        }
    }
}
