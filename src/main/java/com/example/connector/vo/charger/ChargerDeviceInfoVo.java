package com.example.connector.vo.charger;

import com.example.connector.entity.charger.ChargerDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargerDeviceInfoVo {
    private Long id;

    private String wattCode;
    private String cdName;
    private String zdName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short zdFcode;
    private Short cdFcode;
    private String cdPid;
    private Short outCnt;
    private Short phaseCnt;
    private Float inUe;
    private Float inIe;
    private Float inPower;
    private Float outUe;
    private Float outIe;
    private Float outPower;
    private Integer datapoint;
    private String url;
    private Integer offlineCnt;
    private LocalDateTime onlineTime;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private Integer modifyCnt;
    private String checkMan;
    private String authMan;
    private String zdPid;
    private String cdFile;
    private String zdPic;
    private Short state;
    private String remark;

    public ChargerDeviceInfoVo(ChargerDeviceInfo deviceInfo) {
        id = deviceInfo.getId();

        wattCode = deviceInfo.getWattCode();
        cdName = deviceInfo.getCdName();
        zdName = deviceInfo.getZdName();
        addr = deviceInfo.getAddr();
        region = deviceInfo.getRegion();
        lon = deviceInfo.getLon();
        lat = deviceInfo.getLat();

        zdFcode = deviceInfo.getZdFcode();
        cdFcode = deviceInfo.getCdFcode();
        cdPid = deviceInfo.getCdPid();
        outCnt = deviceInfo.getOutCnt();
        phaseCnt = deviceInfo.getPhaseCnt();
        inUe = deviceInfo.getInUe();
        inIe = deviceInfo.getInIe();
        inPower = deviceInfo.getInPower();
        outUe = deviceInfo.getOutUe();
        outIe = deviceInfo.getOutIe();
        outPower = deviceInfo.getOutPower();
        datapoint = deviceInfo.getDatapoint();
        url = deviceInfo.getUrl();

        offlineCnt = deviceInfo.getOfflineCnt();
        onlineTime = deviceInfo.getOnlineTime();
        regDate = deviceInfo.getRegDate();
        modifyDate = deviceInfo.getModifyDate();
        modifyCnt = deviceInfo.getModifyCnt();
        checkMan = deviceInfo.getCheckMan();
        authMan = deviceInfo.getAuthMan();
        zdPid = deviceInfo.getZdPid();
        cdFile = deviceInfo.getCdFile();
        zdPic = deviceInfo.getZdPic();
        state = deviceInfo.getState();
        remark = deviceInfo.getRemark();
    }
}
