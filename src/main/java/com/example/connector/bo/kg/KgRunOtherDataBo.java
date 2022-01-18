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

    private final long time;
    private final float freRt;
    private final float factor;
    private final int ua;
    private final int ub;
    private final int uc;
    private final int uo;
    private final int ia;
    private final int ib;
    private final int ic;
    private final int io;
    private final int uab;
    private final int ubc;
    private final int uca;
    private final float uaThd;
    private final float ubThd;
    private final float ucThd;
    private final float iaThd;
    private final float ibThd;
    private final float icThd;

    public KgRunOtherData getEntity() {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        return new KgRunOtherData(
                null, deviceId, dateTime, freRt, factor, ua, ub, uc, uo, ia, ib, ic, io, uab, ubc,
                uca, uaThd, ubThd, ucThd, iaThd, ibThd, icThd, (short) 1, "ok");
    }
}
