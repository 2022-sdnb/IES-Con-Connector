package com.example.connector.gateway.device;

import com.example.connector.go.device.ResponseGo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Response {
    final ClientToken tk;
    final short cmdId;
    final ResponseGo go;
}
