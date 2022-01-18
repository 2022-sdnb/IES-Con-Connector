package com.example.connector.vo.kg;

import com.example.connector.entity.kg.KgRunElectricityData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgRunElectricityDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Float pwatt;
    private Float qwatt;
    private Short state;
    private String remark;

    public KgRunElectricityDataVo(KgRunElectricityData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        pwatt = data.getPwatt();
        qwatt = data.getQwatt();
        state = data.getState();
        remark = data.getRemark();
    }
}
