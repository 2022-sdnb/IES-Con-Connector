package com.example.connector.bo.chiller;

import com.example.connector.entity.chiller.ChillerRunScheduleData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChillerRunScheduleDataBo {
    private final long deviceId;

    private final Long time;
    private final Short onOffSet;
    private final Float temSet;
    private final Float pLimitSet;

    public ChillerRunScheduleData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChillerRunScheduleData(
                null, deviceId, dateTime, onOffSet, temSet, pLimitSet, (short) 1, "ok");
    }
}
