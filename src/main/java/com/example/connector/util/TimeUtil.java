package com.example.connector.util;

import java.time.Instant;

public class TimeUtil {
    private TimeUtil() {}

    public static long nowUnixTimeStamp() {
        return Instant.now().getEpochSecond();
    }
}
