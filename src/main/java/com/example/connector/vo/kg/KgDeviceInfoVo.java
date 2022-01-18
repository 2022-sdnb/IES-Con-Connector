package com.example.connector.vo.kg;

import com.example.connector.entity.kg.KgDeviceInfo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgDeviceInfoVo {
    private Long id;

    private String wattCode;
    private Integer loadtype;
    private String kgName;
    private String zdName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short zdFcode;
    private String kgType;
    private Short phaseCnt;
    private Float ue;
    private Float umax;
    private Float ie;
    private Float imax;
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
    private String kgFile;
    private String zdPic;
    private Short state;
    private String remark;

    public KgDeviceInfoVo(KgDeviceInfo deviceInfo) {
        id = deviceInfo.getId();
        wattCode = deviceInfo.getWattCode();
        loadtype = deviceInfo.getLoadtype();
        kgName = deviceInfo.getKgName();
        zdName = deviceInfo.getZdName();
        addr = deviceInfo.getAddr();
        region = deviceInfo.getRegion();
        lon = deviceInfo.getLon();
        lat = deviceInfo.getLat();
        zdFcode = deviceInfo.getZdFcode();
        kgType = deviceInfo.getKgType();
        phaseCnt = deviceInfo.getPhaseCnt();
        ue = deviceInfo.getUe();
        umax = deviceInfo.getUmax();
        ie = deviceInfo.getIe();
        imax = deviceInfo.getImax();
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
        kgFile = deviceInfo.getKgFile();
        zdPic = deviceInfo.getZdPic();
        state = deviceInfo.getState();
        remark = deviceInfo.getRemark();
    }
}
