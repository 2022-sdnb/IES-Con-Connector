package com.example.connector.bo.kg;

import com.example.connector.entity.kg.KgRunOtherData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KgRunOtherDataBo {
    private final long deviceId;

    private final Long time;
    private final Float freRt;
    private final Float factor;
    private final Integer ua;
    private final Integer ub;
    private final Integer uc;
    private final Integer uo;
    private final Integer ia;
    private final Integer ib;
    private final Integer ic;
    private final Integer io;
    private final Integer uab;
    private final Integer ubc;
    private final Integer uca;
    private final Float uaThd;
    private final Float ubThd;
    private final Float ucThd;
    private final Float iaThd;
    private final Float ibThd;
    private final Float icThd;

    public KgRunOtherData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new KgRunOtherData(
                null, deviceId, dateTime, freRt, factor, ua, ub, uc, uo, ia, ib, ic, io, uab, ubc,
                uca, uaThd, ubThd, ucThd, iaThd, ibThd, icThd, (short) 1, "ok");
    }
}
