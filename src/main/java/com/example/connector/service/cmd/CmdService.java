package com.example.connector.service.cmd;

import com.example.connector.vo.cmd.ChargerControlVo;
import com.example.connector.vo.cmd.ChillerControlVo;
import com.example.connector.vo.cmd.DeviceInfoPullVo;
import com.example.connector.vo.cmd.DeviceRunDataPullVo;
import com.example.connector.vo.cmd.KgControlVo;

public interface CmdService {
    Long addDeviceInfoUpdateCmd(DeviceInfoPullVo vo);

    Long addDeviceRunDataCmd(DeviceRunDataPullVo vo);

    Long addKgControlCmd(KgControlVo vo);

    Long addChargerControlCmd(ChargerControlVo vo);

    Long addChillerControlCmd(ChillerControlVo vo);
}
