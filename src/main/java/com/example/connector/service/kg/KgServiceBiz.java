package com.example.connector.service.kg;

import com.example.connector.bo.kg.KgDeviceInfoBo;
import com.example.connector.bo.kg.KgRunElectricityDataBo;
import com.example.connector.bo.kg.KgRunOtherDataBo;
import com.example.connector.bo.kg.KgRunPowerDataBo;
import com.example.connector.bo.kg.KgRunStateDataBo;

public interface KgServiceBiz {
    void updateDeviceInfo(KgDeviceInfoBo bo);

    void addRunElectricityData(KgRunElectricityDataBo bo);

    void addRunOtherData(KgRunOtherDataBo bo);

    void addRunPowerData(KgRunPowerDataBo bo);

    void addRunStateData(KgRunStateDataBo bo);
}
