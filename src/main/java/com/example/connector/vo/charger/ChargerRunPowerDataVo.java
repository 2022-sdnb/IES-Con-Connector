package com.example.connector.vo.charger;

import com.example.connector.entity.charger.ChargerRunPowerData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargerRunPowerDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;

    private Float pinRt;
    private Float qinRt;
    private Short state;
    private String remark;

    public ChargerRunPowerDataVo(ChargerRunPowerData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        pinRt = data.getPinRt();
        qinRt = data.getQinRt();
        state = data.getState();
        remark = data.getRemark();
    }

    /** for test usage */
    public ChargerRunPowerDataVo(long deviceId) {
        this.deviceId = deviceId;
    }

    public static ChargerRunPowerDataVo fromEntity(ChargerRunPowerData data) {
        return new ChargerRunPowerDataVo(data.getDeviceId());
    }
}
