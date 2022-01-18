package com.example.connector.bo.kg;

import com.example.connector.entity.kg.KgRunPowerData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KgRunPowerDataBo {
    private final long deviceId;

    private final long time;
    private final float pRt;
    private final float qRt;

    public KgRunPowerData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new KgRunPowerData(null, deviceId, dateTime, pRt, qRt, (short) 1, "ok");
    }
}
