package com.example.connector.vo.chiller;

import com.example.connector.entity.chiller.ChillerRunData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChillerRunDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Float pwatt;
    private Float qwatt;
    private Float chInTemp;
    private Float chOutTemp;
    private Float coInTemp;
    private Float coOutTemp;
    private Float evaTemp;
    private Float conTemp;
    private Float evaPressure;
    private Float conPressure;
    private Short state;
    private String remark;

    public ChillerRunDataVo(ChillerRunData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        pwatt = data.getPwatt();
        qwatt = data.getQwatt();
        chInTemp = data.getChInTemp();
        chOutTemp = data.getChOutTemp();
        coInTemp = data.getCoInTemp();
        coOutTemp = data.getCoOutTemp();
        evaTemp = data.getEvaTemp();
        conTemp = data.getConTemp();
        evaPressure = data.getEvaPressure();
        conPressure = data.getConPressure();
        state = data.getState();
        remark = data.getRemark();
    }
}
