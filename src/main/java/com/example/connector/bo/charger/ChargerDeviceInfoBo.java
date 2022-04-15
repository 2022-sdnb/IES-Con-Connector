package com.example.connector.bo.charger;

import com.example.connector.entity.charger.ChargerDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargerDeviceInfoBo {
    private final long id;

    private final Short zdFcode;
    private final Short cdFcode;
    private final String cdPid;
    private final Short outCnt;
    private final Short phaseCnt;
    private final Float inUe;
    private final Float inIe;
    private final Float inPower;
    private final Float outUe;
    private final Float outIe;
    private final Float outPower;
    private final Integer datapoint;

    public void updateEntity(ChargerDeviceInfo deviceInfo) {
        deviceInfo.setZdFcode(zdFcode);
        deviceInfo.setCdFcode((cdFcode));
        deviceInfo.setCdPid(cdPid);
        deviceInfo.setOutCnt(outCnt);
        deviceInfo.setPhaseCnt(phaseCnt);
        deviceInfo.setInUe(inUe);
        deviceInfo.setInIe(inIe);
        deviceInfo.setInPower(inPower);
        deviceInfo.setOutUe(outUe);
        deviceInfo.setOutIe(outIe);
        deviceInfo.setOutPower(outPower);
        deviceInfo.setDatapoint(datapoint);
        deviceInfo.setModifyDate(LocalDateTime.now());
        deviceInfo.setModifyCnt(deviceInfo.getModifyCnt() + 1);
    }
}
