package com.example.connector.bo.chiller;

import com.example.connector.entity.chiller.ChillerRunPowerData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChillerRunPowerDataBo {
    private final long deviceId;

    private final Long time;
    private final Float pRt;
    private final Float qRt;

    public ChillerRunPowerData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChillerRunPowerData(null, deviceId, dateTime, pRt, qRt, (short) 1, "ok");
    }
}
