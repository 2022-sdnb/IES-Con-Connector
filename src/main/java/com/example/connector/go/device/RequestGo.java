package com.example.connector.go.device;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestGo {
    private final long time;
    private final short type;
    private final String data;
}
