package com.example.connector.bo.gw;

import com.example.connector.entity.gw.GwDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GwDeviceInfoBo {
    private final long id;

    private final short gwFcode;
    private final int genCnt;
    private final float genKw;
    private final int loadCnt;
    private final float loadKw;
    private final int storageCnt;
    private final float storageKw;
    private final int chargerCnt;
    private final float chargerKw;
    private final int datapoint;

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
