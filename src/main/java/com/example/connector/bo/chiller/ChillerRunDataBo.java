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

    private final Long time;
    private final Float pwatt;
    private final Float qwatt;
    private final Float chInTemp;
    private final Float chOutTemp;
    private final Float coInTemp;
    private final Float coOutTemp;
    private final Float evaTemp;
    private final Float conTemp;
    private final Float evaPressure;
    private final Float conPressure;

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
