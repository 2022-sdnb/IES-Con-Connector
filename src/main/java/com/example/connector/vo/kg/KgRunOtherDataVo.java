package com.example.connector.vo.kg;

import com.example.connector.entity.kg.KgRunOtherData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgRunOtherDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Float freRt;
    private Float factor;
    private Integer ua;
    private Integer ub;
    private Integer uc;
    private Integer uo;
    private Integer ia;
    private Integer ib;
    private Integer ic;
    private Integer io;
    private Integer uab;
    private Integer ubc;
    private Integer uca;
    private Float uaThd;
    private Float ubThd;
    private Float ucThd;
    private Float iaThd;
    private Float ibThd;
    private Float icThd;
    private Short state;
    private String remark;

    public KgRunOtherDataVo(KgRunOtherData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        freRt = data.getFreRt();
        factor = data.getFactor();
        ua = data.getUa();
        ub = data.getUb();
        uc = data.getUc();
        uo = data.getUo();
        ia = data.getIa();
        ib = data.getIb();
        ic = data.getIc();
        io = data.getIo();
        uab = data.getUab();
        ubc = data.getUbc();
        uca = data.getUca();
        uaThd = data.getUaThd();
        ubThd = data.getUbThd();
        ucThd = data.getUcThd();
        iaThd = data.getIaThd();
        ibThd = data.getIbThd();
        icThd = data.getIcThd();
        state = data.getState();
        remark = data.getRemark();
    }
}
