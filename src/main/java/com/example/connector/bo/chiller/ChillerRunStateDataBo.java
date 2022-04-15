package com.example.connector.bo.chiller;

import com.example.connector.entity.chiller.ChillerRunStateData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChillerRunStateDataBo {
    private final long deviceId;

    private final Long time;
    private final Short ktState;
    private final String ktMsg;
    private final Short zdState;
    private final String zdMsg;
    private final Short localState;
    private final Short refStatus;
    private final Short evaState;
    private final Short conState;
    private final Integer comStartsCnt;
    private final Long runTime;

    public ChillerRunStateData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChillerRunStateData(
                null,
                deviceId,
                dateTime,
                ktState,
                ktMsg,
                zdState,
                zdMsg,
                localState,
                refStatus,
                evaState,
                conState,
                comStartsCnt,
                runTime,
                (short) 1,
                "ok");
    }
}
