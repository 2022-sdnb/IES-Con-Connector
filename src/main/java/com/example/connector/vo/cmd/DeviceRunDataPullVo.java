package com.example.connector.vo.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceRunDataPullVo {
    private long clientId;
    private Long time;
}
