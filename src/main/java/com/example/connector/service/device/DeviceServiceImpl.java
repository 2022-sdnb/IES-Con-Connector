package com.example.connector.service.device;

import com.example.connector.bo.device.DeviceBo;
import com.example.connector.exception.NotFoundException;
import com.example.connector.repo.device.DeviceRepo;
import com.example.connector.vo.device.DeviceVo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService, DeviceServiceBiz {
    @Autowired DeviceRepo repo;

    @Override
    public List<DeviceVo> getAllDevices() {
        return repo.findAll().stream().map(DeviceVo::new).collect(Collectors.toList());
    }

    @Override
    public DeviceVo getDevice(Long uid) {
        var vo = repo.findById(uid).map(DeviceVo::new).orElse(null);

        if (vo == null) throw new NotFoundException(DeviceVo.class, new String[] {"Uid"});

        return vo;
    }

    @Override
    public DeviceBo createDevice(DeviceBo bo) {
        var entity = repo.save(bo.getEntity());
        return new DeviceBo(entity);
    }

    public List<DeviceBo> getAllDeviceBos() {
        return repo.findAll().stream().map(DeviceBo::new).collect(Collectors.toList());
    }
}
