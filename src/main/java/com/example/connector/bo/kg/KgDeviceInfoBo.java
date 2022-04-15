package com.example.connector.bo.kg;

import com.example.connector.entity.kg.KgDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KgDeviceInfoBo {
    private final long id;

    private final Short zdFcode;
    private final String kgType;
    private final Short phaseCnt;
    private final Float ue;
    private final Float umax;
    private final Float ie;
    private final Float imax;
    private final Integer datapoint;

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
