package com.example.connector.vo.chiller;

import com.example.connector.entity.chiller.ChillerRunStateData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChillerRunStateDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Short ktState;
    private String ktMsg;
    private Short zdState;
    private String zdMsg;
    private Short localState;
    private Short refStatus;
    private Short evaState;
    private Short conState;
    private Integer comStartsCnt;
    private Long runTime;
    private Short state;
    private String remark;

    public ChillerRunStateDataVo(ChillerRunStateData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        ktState = data.getKtState();
        ktMsg = data.getKtMsg();
        zdState = data.getZdState();
        zdMsg = data.getZdMsg();
        localState = data.getLocalState();
        refStatus = data.getRefStatus();
        evaState = data.getEvaState();
        conState = data.getConState();
        comStartsCnt = data.getComStartsCnt();
        runTime = data.getRunTime();
        state = data.getState();
        remark = data.getRemark();
    }
}
