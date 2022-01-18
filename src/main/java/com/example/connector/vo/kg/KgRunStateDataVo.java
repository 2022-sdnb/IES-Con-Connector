package com.example.connector.vo.kg;

import com.example.connector.entity.kg.KgRunStateData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgRunStateDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Short kgState;
    private String kgMsg;
    private Short zdState;
    private String zdMsg;
    private Short state;
    private String remark;

    public KgRunStateDataVo(KgRunStateData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        kgState = data.getKgState();
        kgMsg = data.getKgMsg();
        zdState = data.getZdState();
        zdMsg = data.getZdMsg();
        state = data.getState();
        remark = data.getRemark();
    }
}
