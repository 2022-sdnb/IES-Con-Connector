package com.example.connector.bo.chiller;

import com.example.connector.entity.chiller.ChillerDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChillerDeviceInfoBo {
    private final long id;

    private final short ktFcode;
    private final String ktPid;
    private final float capCool;
    private final float capHeat;
    private final float iStart;
    private final float iMax;
    private final float iMin;
    private final float iBreak;
    private final float uIn;
    private final short phaseCnt;
    private final int dataPoint;

    public void updateEntity(ChillerDeviceInfo deviceInfo) {
        deviceInfo.setKtFcode(ktFcode);
        deviceInfo.setKtPid(ktPid);
        deviceInfo.setCapCool(capCool);
        deviceInfo.setCapHeat(capHeat);
        deviceInfo.setIstart(iStart);
        deviceInfo.setImax(iMax);
        deviceInfo.setImin(iMin);
        deviceInfo.setIbreak(iBreak);
        deviceInfo.setUin(uIn);
        deviceInfo.setPhaseCnt(phaseCnt);
        deviceInfo.setDatapoint(dataPoint);
        deviceInfo.setModifyDate(LocalDateTime.now());
        deviceInfo.setModifyCnt(deviceInfo.getModifyCnt() + 1);
    }
}
