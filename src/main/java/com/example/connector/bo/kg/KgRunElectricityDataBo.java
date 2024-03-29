package com.example.connector.bo.kg;

import com.example.connector.entity.kg.KgRunElectricityData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KgRunElectricityDataBo {
    private final long deviceId;

    private final Long time;
    private final Float pwatt;
    private final Float qwatt;

    public KgRunElectricityData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new KgRunElectricityData(null, deviceId, dateTime, pwatt, qwatt, (short) 1, "ok");
    }
}
