package com.example.connector.gateway.device;

import com.example.connector.go.device.RequestGo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Request {
    final ClientToken tk;
    final long clientId;
    final long gatewayId;
    final short cmdId;
    final RequestGo go;
}
