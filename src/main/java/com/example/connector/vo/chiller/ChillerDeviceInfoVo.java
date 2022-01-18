package com.example.connector.vo.chiller;

import com.example.connector.entity.chiller.ChillerDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChillerDeviceInfoVo {
    private Long id;

    private String wattCode;
    private String ktName;
    private String zdName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short ktFcode;
    private String ktPid;
    private Float capCool;
    private Float capHeat;
    private Float istart;
    private Float imax;
    private Float imin;
    private Float ibreak;
    private Float uin;
    private Short phaseCnt;
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
    private String ktFile;
    private String zdPic;
    private Short state;
    private String remark;

    public ChillerDeviceInfoVo(ChillerDeviceInfo deviceInfo) {
        id = deviceInfo.getId();

        wattCode = deviceInfo.getWattCode();

        ktName = deviceInfo.getKtName();
        zdName = deviceInfo.getZdName();
        addr = deviceInfo.getAddr();
        region = deviceInfo.getRegion();
        lon = deviceInfo.getLon();
        lat = deviceInfo.getLat();

        ktFcode = deviceInfo.getKtFcode();
        ktPid = deviceInfo.getKtPid();
        capCool = deviceInfo.getCapCool();
        capHeat = deviceInfo.getCapHeat();
        istart = deviceInfo.getIstart();
        imax = deviceInfo.getImax();
        imin = deviceInfo.getImin();
        ibreak = deviceInfo.getIbreak();
        uin = deviceInfo.getUin();
        phaseCnt = deviceInfo.getPhaseCnt();
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
        ktFile = deviceInfo.getKtFile();
        zdPic = deviceInfo.getZdPic();
        state = deviceInfo.getState();
        remark = deviceInfo.getRemark();
    }
}
