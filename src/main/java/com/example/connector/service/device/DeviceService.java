package com.example.connector.service.device;

import com.example.connector.vo.device.DeviceVo;
import java.util.List;

public interface DeviceService {
    List<DeviceVo> getAllDevices();

    DeviceVo getDevice(Long id);
}
