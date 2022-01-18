package com.example.connector.service.chiller;

import com.example.connector.bo.chiller.ChillerDeviceInfoBo;
import com.example.connector.bo.chiller.ChillerRunDataBo;
import com.example.connector.bo.chiller.ChillerRunPowerDataBo;
import com.example.connector.bo.chiller.ChillerRunScheduleDataBo;
import com.example.connector.bo.chiller.ChillerRunStateDataBo;

/**
 * @author Lmt
 * @date 2021/10/10 10:09
 */
public interface ChillerServiceBiz {
    void updateDeviceInfo(ChillerDeviceInfoBo bo);

    void addRunStateData(ChillerRunStateDataBo bo);

    void addRunScheduleData(ChillerRunScheduleDataBo bo);

    void addRunPowerData(ChillerRunPowerDataBo bo);

    void addRunData(ChillerRunDataBo bo);
}
