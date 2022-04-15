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

    private final Long time;
    private final Float factor;
    private final Float ua;
    private final Float ub;
    private final Float uc;
    private final Float uo;
    private final Float ia;
    private final Float ib;
    private final Float ic;
    private final Float io;
    private final Float uab;
    private final Float ubc;
    private final Float uca;
    private final Float uaThd;
    private final Float ubThd;
    private final Float ucThd;
    private final Float iaThd;
    private final Float ibThd;
    private final Float icThd;

    public ChargerRunOtherData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new ChargerRunOtherData(
                null, deviceId, dateTime, factor, ua, ub, uc, uo, ia, ib, ic, io, uab, ubc, uca,
                uaThd, ubThd, ucThd, iaThd, ibThd, icThd, (short) 1, "ok");
    }
}
