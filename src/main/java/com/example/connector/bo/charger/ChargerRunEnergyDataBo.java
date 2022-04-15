package com.example.connector.bo.charger;

import com.example.connector.entity.charger.ChargerRunEnergyData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargerRunEnergyDataBo {
    private final long deviceId;

    private final Long time;
    private final Float pwattIn;
    private final Float qwattIn;

    public ChargerRunEnergyData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChargerRunEnergyData(null, deviceId, dateTime, pwattIn, qwattIn);
    }
}
