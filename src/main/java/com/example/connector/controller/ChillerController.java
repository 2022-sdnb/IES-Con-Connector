package com.example.connector.controller;

import com.example.connector.service.chiller.ChillerService;
import com.example.connector.vo.chiller.ChillerDeviceInfoVo;
import com.example.connector.vo.chiller.ChillerRunDataVo;
import com.example.connector.vo.chiller.ChillerRunPowerDataVo;
import com.example.connector.vo.chiller.ChillerRunStateDataVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "chiller")
public class ChillerController {
    @Autowired ChillerService service;

    @GetMapping(value = "device-info")
    public List<ChillerDeviceInfoVo> getAllDeviceInfos() {
        return service.getAllDeviceInfos();
    }

    @GetMapping(value = "{id}/run-other-data")
    public List<ChillerRunDataVo> getAllRunOtherDatas(@PathVariable Long id) {
        return service.getAllRunOtherDatas(id);
    }

    @GetMapping(value = "{id}/run-power-data")
    public List<ChillerRunPowerDataVo> getAllRunPowerDatas(@PathVariable Long id) {
        return service.getAllRunPowerDatas(id);
    }

    @GetMapping(value = "{id}/run-state-data")
    public List<ChillerRunStateDataVo> getAllRunStateDatas(@PathVariable Long id) {
        return service.getAllRunStateDatas(id);
    }
}
