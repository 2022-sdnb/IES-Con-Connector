package com.example.connector.gateway.device;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class SignInResponse {
    final ClientToken tk;
    final short cmdId;
    final byte status;
}
