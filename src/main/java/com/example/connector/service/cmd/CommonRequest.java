package com.example.connector.service.cmd;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
class HeartbeatCommonRequest {
    @SerializedName("msg")
    private String msg;
}
