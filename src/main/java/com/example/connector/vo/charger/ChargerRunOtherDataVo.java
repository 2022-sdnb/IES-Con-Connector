package com.example.connector.vo.charger;

import com.example.connector.entity.charger.ChargerRunOtherData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargerRunOtherDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;

    private Float factor;
    private Float ua;
    private Float ub;
    private Float uc;
    private Float uo;
    private Float ia;
    private Float ib;
    private Float ic;
    private Float io;
    private Float uab;
    private Float ubc;
    private Float uca;
    private Float uaThd;
    private Float ubThd;
    private Float ucThd;
    private Float iaThd;
    private Float ibThd;
    private Float icThd;
    private Short state;
    private String remark;

    public ChargerRunOtherDataVo(ChargerRunOtherData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();

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
