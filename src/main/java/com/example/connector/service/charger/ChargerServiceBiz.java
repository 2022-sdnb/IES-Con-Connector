package com.example.connector.service.charger;

import com.example.connector.bo.charger.*;

/**
 * @author Lmt
 * @date 2021/10/10 15:37
 */
public interface ChargerServiceBiz {
    void updateDeviceInfo(ChargerDeviceInfoBo bo);

    void addRunOtherData(ChargerRunOtherDataBo bo);

    void addRunPowerData(ChargerRunPowerDataBo bo);

    void addRunStateData(ChargerRunStateDataBo bo);

    void addRunEnergyData(ChargerRunEnergyDataBo bo);

    void addRunElectricityData(ChargerRunElectricityDataBo bo);
}
