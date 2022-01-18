package com.example.connector.go.device;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseGo {
    private final long time;
    private final byte status;
    private final String data;
}
