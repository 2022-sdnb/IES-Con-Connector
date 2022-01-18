package com.example.connector.bo.charger;

import com.example.connector.entity.charger.ChargerRunElectricityData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargerRunElectricityDataBo {
    private final long deviceId;

    private final long time;
    private final long startTime;
    private final float pwatt1;
    private final float pwatt2;
    private final float pwatt3;
    private final float pwatt4;
    private final float income1;
    private final float income2;
    private final float income3;
    private final float income4;

    public ChargerRunElectricityData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
        LocalDateTime startDateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(startTime), ZoneId.systemDefault());
        return new ChargerRunElectricityData(
                null,
                deviceId,
                dateTime,
                startDateTime,
                pwatt1,
                pwatt2,
                pwatt3,
                pwatt4,
                income1,
                income2,
                income3,
                income4,
                (short) 1,
                "ok");
    }
}
