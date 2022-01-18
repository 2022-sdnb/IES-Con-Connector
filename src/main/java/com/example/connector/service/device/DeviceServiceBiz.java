package com.example.connector.service.device;

import com.example.connector.bo.device.DeviceBo;
import java.util.List;

public interface DeviceServiceBiz {
    DeviceBo createDevice(DeviceBo vo);

    List<DeviceBo> getAllDeviceBos();
}
