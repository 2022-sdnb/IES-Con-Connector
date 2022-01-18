package com.example.connector.controller;

import com.example.connector.service.cmd.CmdService;
import com.example.connector.vo.cmd.ChargerControlVo;
import com.example.connector.vo.cmd.ChillerControlVo;
import com.example.connector.vo.cmd.DeviceInfoPullVo;
import com.example.connector.vo.cmd.DeviceRunDataPullVo;
import com.example.connector.vo.cmd.KgControlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cmd")
public class CmdController {
    @Autowired CmdService service;

    @PostMapping(value = "device-info-update")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Long postDeviceInfoUpdateCmd(DeviceInfoPullVo vo) {
        return service.addDeviceInfoUpdateCmd(vo);
    }

    @PostMapping(value = "device-run-data")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Long postDeviceRunDataCmd(DeviceRunDataPullVo vo) {
        return service.addDeviceRunDataCmd(vo);
    }

    @PostMapping(value = "kg-control")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Long postKgControlCmd(KgControlVo vo) {
        return service.addKgControlCmd(vo);
    }

    @PostMapping(value = "charger-control")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Long postChargerControlCmd(ChargerControlVo vo) {
        return service.addChargerControlCmd(vo);
    }

    @PostMapping(value = "chiller-control")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Long postChillerControlCmd(ChillerControlVo vo) {
        return service.addChillerControlCmd(vo);
    }
}
