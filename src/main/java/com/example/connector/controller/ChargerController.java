package com.example.connector.controller;

import com.example.connector.service.charger.ChargerService;
import com.example.connector.vo.charger.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "charger")
public class ChargerController {
    @Autowired ChargerService service;

    @GetMapping(value = "device-info")
    public List<ChargerDeviceInfoVo> getAllDeviceInfos() {
        return service.getAllDeviceInfos();
    }

    @GetMapping(value = "{id}/run-electricity-data")
    public List<ChargerRunElectricityDataVo> getAllRunElectricityDatas(@PathVariable Long id) {
        return service.getAllRunElectricityDatas(id);
    }

    @GetMapping(value = "{id}/run-other-data")
    public List<ChargerRunOtherDataVo> getAllRunOtherDatas(@PathVariable Long id) {
        return service.getAllRunOtherDatas(id);
    }

    @GetMapping(value = "{id}/run-power-data")
    public List<ChargerRunPowerDataVo> getAllRunPowerDatas(@PathVariable Long id) {
        return service.getAllRunPowerDatas(id);
    }

    @GetMapping(value = "{id}/run-state-data")
    public List<ChargerRunStateDataVo> getAllRunStateDatas(@PathVariable Long id) {
        return service.getAllRunStateDatas(id);
    }
}
