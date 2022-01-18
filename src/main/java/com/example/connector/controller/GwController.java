package com.example.connector.controller;

import com.example.connector.service.gw.GwService;
import com.example.connector.vo.gw.GwDeviceInfoVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "gw")
public class GwController {
    @Autowired GwService service;

    @GetMapping(value = "device-info")
    public List<GwDeviceInfoVo> getAllDeviceInfos() {
        return service.getAllDeviceInfos();
    }
}
