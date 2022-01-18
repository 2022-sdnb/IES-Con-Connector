package com.example.connector.controller;

import com.example.connector.service.kg.KgService;
import com.example.connector.vo.kg.KgDeviceInfoVo;
import com.example.connector.vo.kg.KgRunElectricityDataVo;
import com.example.connector.vo.kg.KgRunOtherDataVo;
import com.example.connector.vo.kg.KgRunPowerDataVo;
import com.example.connector.vo.kg.KgRunStateDataVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "kg")
public class KgController {
    @Autowired KgService service;

    @GetMapping(value = "device-info")
    public List<KgDeviceInfoVo> getAllDeviceInfos() {
        return service.getAllDeviceInfos();
    }

    @GetMapping(value = "{id}/run-electricity-data")
    public List<KgRunElectricityDataVo> getAllRunElectricityDatas(@PathVariable Long id) {
        return service.getAllRunElectricityDatas(id);
    }

    @GetMapping(value = "{id}/run-other-data")
    public List<KgRunOtherDataVo> getAllRunOtherDatas(@PathVariable Long id) {
        return service.getAllRunOtherDatas(id);
    }

    @GetMapping(value = "{id}/run-power-data")
    public List<KgRunPowerDataVo> getAllRunPowerDatas(@PathVariable Long id) {
        return service.getAllRunPowerDatas(id);
    }

    @GetMapping(value = "{id}/run-state-data")
    public List<KgRunStateDataVo> getAllRunStateDatas(@PathVariable Long id) {
        return service.getAllRunStateDatas(id);
    }
}
