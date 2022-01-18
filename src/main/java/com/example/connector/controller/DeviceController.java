package com.example.connector.controller;

import com.example.connector.service.device.DeviceService;
import com.example.connector.vo.device.DeviceVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "device")
public class DeviceController {
    @Autowired DeviceService service;

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<DeviceVo> getAll() {
        return service.getAllDevices();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public DeviceVo get(@PathVariable Long id) {
        return service.getDevice(id);
    }
}
