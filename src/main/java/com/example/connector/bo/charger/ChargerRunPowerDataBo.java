package com.example.connector.bo.charger;

import com.example.connector.entity.charger.ChargerRunPowerData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargerRunPowerDataBo {
    private final long deviceId;

    private final Long time;
    private final Float pinRt;
    private final Float qinRt;

    public ChargerRunPowerData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChargerRunPowerData(null, deviceId, dateTime, pinRt, qinRt, (short) 1, "ok");
    }
}
