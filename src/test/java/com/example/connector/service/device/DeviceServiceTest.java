package com.example.connector.service.device;

import static org.junit.jupiter.api.Assertions.*;

import com.example.connector.entity.device.Device;
import com.example.connector.exception.NotFoundException;
import com.example.connector.repo.device.DeviceRepo;
import com.example.connector.vo.device.DeviceVo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DeviceServiceTest {

    private final List<Device> devices =
            Arrays.asList(
                    new Device("0.0.0.0", 1),
                    new Device("0.0.0.0", 2),
                    new Device("0.0.0.0", 3),
                    new Device("0.0.0.0", 4));

    private List<DeviceVo> deviceVos =
            devices.stream().map(DeviceVo::new).collect(Collectors.toList());

    @Autowired DeviceService service;

    @MockBean DeviceRepo repo;

    @Test
    void getAllDevices() {
        Mockito.when(repo.findAll()).thenReturn(devices);

        List<DeviceVo> actualVos = service.getAllDevices();
        for (int i = 0; i < deviceVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(deviceVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getDevice1() {
        long id = 1;
        int port = 2;
        Mockito.when(repo.findById(id))
                .thenReturn(java.util.Optional.ofNullable(devices.get((int) id)));

        DeviceVo vo = service.getDevice(id);
        assertNotNull(vo);
        assertEquals(port, vo.getPort());
    }

    @Test
    void getDevice2() {
        long id = 4;
        Mockito.when(repo.findById(id)).thenReturn(java.util.Optional.empty());

        try {
            DeviceVo vo = service.getDevice(id);
            // when null returned, should not continue
            fail();
        } catch (NotFoundException e) {
            assertTrue(true);
        }
    }
}
