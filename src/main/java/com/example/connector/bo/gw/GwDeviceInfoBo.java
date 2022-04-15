package com.example.connector.bo.gw;

import com.example.connector.entity.gw.GwDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GwDeviceInfoBo {
    private final long id;

    private final Short gwFcode;
    private final Integer genCnt;
    private final Float genKw;
    private final Integer loadCnt;
    private final Float loadKw;
    private final Integer storageCnt;
    private final Float storageKw;
    private final Integer chargerCnt;
    private final Float chargerKw;
    private final Integer datapoint;

    public void updateEntity(GwDeviceInfo deviceInfo) {
        deviceInfo.setGwFcode(gwFcode);
        deviceInfo.setGenCnt(genCnt);
        deviceInfo.setGenKw(genKw);
        deviceInfo.setLoadCnt(loadCnt);
        deviceInfo.setLoadKw(loadKw);
        deviceInfo.setStorageCnt(storageCnt);
        deviceInfo.setStorageKw(storageKw);
        deviceInfo.setChargerCnt(chargerCnt);
        deviceInfo.setChargerKw(chargerKw);
        deviceInfo.setDatapoint(datapoint);
        deviceInfo.setModifyDate(LocalDateTime.now());
        deviceInfo.setModifyCnt(deviceInfo.getModifyCnt());
    }
}
