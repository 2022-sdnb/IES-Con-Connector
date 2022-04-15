package com.example.connector.bo.kg;

import com.example.connector.entity.kg.KgRunStateData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KgRunStateDataBo {
    private final long deviceId;

    private final Long time;
    private final short kgState;
    private final String kgMsg;
    private final short zdState;
    private final String zdMsg;

    public KgRunStateData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new KgRunStateData(
                null, deviceId, dateTime, kgState, kgMsg, zdState, zdMsg, (short) 1, "ok");
    }
}
