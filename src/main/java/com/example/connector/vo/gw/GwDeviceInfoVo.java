package com.example.connector.vo.gw;

import com.example.connector.entity.gw.GwDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GwDeviceInfoVo {
    private Long id;

    private String gwposName;
    private String gwName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short gwFcode;
    private Integer genCnt;
    private Float genKw;
    private Integer loadCnt;
    private Float loadKw;
    private Integer storageCnt;
    private Float storageKw;
    private Integer chargerCnt;
    private Float chargerKw;
    private Integer datapoint;
    private String url;
    private Integer offlineCnt;
    private LocalDateTime onlineTime;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private Integer modifyCnt;
    private String checkMan;
    private String authMan;
    private String gwPid;
    private String gwPic;
    private Short state;
    private String remark;

    public GwDeviceInfoVo(GwDeviceInfo info) {
        id = info.getId();
        gwposName = info.getGwposName();
        gwName = info.getGwName();
        addr = info.getAddr();
        region = info.getRegion();
        lon = info.getLon();
        lat = info.getLat();
        gwFcode = info.getGwFcode();
        genCnt = info.getGenCnt();
        genKw = info.getGenKw();
        loadCnt = info.getLoadCnt();
        loadKw = info.getLoadKw();
        storageCnt = info.getStorageCnt();
        storageKw = info.getStorageKw();
        chargerCnt = info.getChargerCnt();
        chargerKw = info.getChargerKw();
        datapoint = info.getDatapoint();
        url = info.getUrl();
        offlineCnt = info.getOfflineCnt();
        onlineTime = info.getOnlineTime();
        regDate = info.getRegDate();
        modifyDate = info.getModifyDate();
        modifyCnt = info.getModifyCnt();
        checkMan = info.getCheckMan();
        authMan = info.getAuthMan();
        gwPid = info.getGwPid();
        gwPic = info.getGwPic();
        state = info.getState();
        remark = info.getRemark();
    }
}
