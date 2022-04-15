package com.example.connector.bo.charger;

import com.example.connector.entity.charger.ChargerRunStateData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargerRunStateDataBo {
    private final long deviceId;

    private final Long time;
    private final Short cdState;
    private final String cdMsg;
    private final Short zdState;
    private final String zdMsg;
    private final Short cdFlag1;
    private final Short cdFlag2;
    private final Short cdFlag3;
    private final Short cdFlag4;

    public ChargerRunStateData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChargerRunStateData(
                null, deviceId, dateTime, cdState, cdMsg, zdState, zdMsg, cdFlag1, cdFlag2, cdFlag3,
                cdFlag4, (short) 1, "ok");
    }
}
