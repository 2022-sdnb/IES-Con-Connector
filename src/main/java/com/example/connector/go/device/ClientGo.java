package com.example.connector.go.device;

import java.net.InetSocketAddress;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientGo {
    private final long id;
    private final long gatewayId;
    private final InetSocketAddress addr;
}
