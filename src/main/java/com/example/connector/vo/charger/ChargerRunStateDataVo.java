package com.example.connector.vo.charger;

import com.example.connector.entity.charger.ChargerRunStateData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargerRunStateDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;

    private Short cdState;
    private String cdMsg;
    private Short zdState;
    private String zdMsg;
    private Short cdFlag1;
    private Short cdFlag2;
    private Short cdFlag3;
    private Short cdFlag4;
    private Short state;
    private String remark;

    public ChargerRunStateDataVo(ChargerRunStateData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        cdState = data.getCdState();
        cdMsg = data.getCdMsg();
        zdState = data.getZdState();
        zdMsg = data.getZdMsg();
        cdFlag1 = data.getCdFlag1();
        cdFlag2 = data.getCdFlag2();
        cdFlag3 = data.getCdFlag3();
        cdFlag4 = data.getCdFlag4();
        state = data.getState();
        remark = data.getRemark();
    }

    /** for test usage */
    public ChargerRunStateDataVo(long deviceId) {
        this.deviceId = deviceId;
    }

    public static ChargerRunStateDataVo fromEntity(ChargerRunStateData data) {
        return new ChargerRunStateDataVo(data.getDeviceId());
    }
}
