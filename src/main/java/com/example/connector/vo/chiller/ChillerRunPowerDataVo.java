package com.example.connector.vo.chiller;

import com.example.connector.entity.chiller.ChillerRunPowerData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChillerRunPowerDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;

    private Float pRt;
    private Float qRt;
    private Short state;
    private String remark;

    public ChillerRunPowerDataVo(ChillerRunPowerData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        pRt = data.getPRt();
        state = data.getState();
        remark = data.getRemark();
    }
}
