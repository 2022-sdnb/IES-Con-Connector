package com.example.connector.bo.chiller;

import com.example.connector.entity.chiller.ChillerRunData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChillerRunDataBo {
    private final long deviceId;

    private final long time;
    private final float pwatt;
    private final float qwatt;
    private final float chInTemp;
    private final float chOutTemp;
    private final float coInTemp;
    private final float coOutTemp;
    private final float evaTemp;
    private final float conTemp;
    private final float evaPressure;
    private final float conPressure;

    public ChillerRunData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
        return new ChillerRunData(
                null,
                deviceId,
                dateTime,
                pwatt,
                qwatt,
                chInTemp,
                chOutTemp,
                coInTemp,
                coOutTemp,
                evaTemp,
                conTemp,
                evaPressure,
                conPressure,
                (short) 1,
                "ok");
    }
}
