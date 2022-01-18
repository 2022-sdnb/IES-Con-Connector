package com.example.connector.bo.kg;

import com.example.connector.entity.kg.KgDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KgDeviceInfoBo {
    private final long id;

    private final short zdFcode;
    private final String kgType;
    private final short phaseCnt;
    private final float ue;
    private final float umax;
    private final float ie;
    private final float imax;
    private final int datapoint;

    public void updateEntity(KgDeviceInfo deviceInfo) {
        deviceInfo.setZdFcode(zdFcode);
        deviceInfo.setKgType(kgType);
        deviceInfo.setPhaseCnt(phaseCnt);
        deviceInfo.setUe(ue);
        deviceInfo.setUmax(umax);
        deviceInfo.setIe(ie);
        deviceInfo.setImax(imax);
        deviceInfo.setDatapoint(datapoint);
        deviceInfo.setModifyDate(LocalDateTime.now());
        deviceInfo.setModifyCnt(deviceInfo.getModifyCnt() + 1);
    }
}
