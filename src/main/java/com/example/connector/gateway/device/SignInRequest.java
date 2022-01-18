package com.example.connector.gateway.device;

import java.net.InetSocketAddress;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class SignInRequest {
    final ClientToken tk;
    final InetSocketAddress addr;
    final short cmdId;
    final long gatewayId;
    final long clientId;
}
