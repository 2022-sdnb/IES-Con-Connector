package com.example.connector.bo.charger;

import com.example.connector.entity.charger.ChargerDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargerDeviceInfoBo {
    private final long id;

    private final short zdFcode;
    private final short cdFcode;
    private final String cdPid;
    private final short outCnt;
    private final short phaseCnt;
    private final float inUe;
    private final float inIe;
    private final float inPower;
    private final float outUe;
    private final float outIe;
    private final float outPower;
    private final int datapoint;

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
