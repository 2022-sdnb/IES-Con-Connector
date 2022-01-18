package com.example.connector.bo.charger;

import com.example.connector.entity.charger.ChargerRunOtherData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargerRunOtherDataBo {
    private final long deviceId;

    private final long time;
    private final float factor;
    private final float ua;
    private final float ub;
    private final float uc;
    private final float uo;
    private final float ia;
    private final float ib;
    private final float ic;
    private final float io;
    private final float uab;
    private final float ubc;
    private final float uca;
    private final float uaThd;
    private final float ubThd;
    private final float ucThd;
    private final float iaThd;
    private final float ibThd;
    private final float icThd;

    public ChargerRunOtherData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChargerRunOtherData(
                null, deviceId, dateTime, factor, ua, ub, uc, uo, ia, ib, ic, io, uab, ubc, uca,
                uaThd, ubThd, ucThd, iaThd, ibThd, icThd, (short) 1, "ok");
    }
}
