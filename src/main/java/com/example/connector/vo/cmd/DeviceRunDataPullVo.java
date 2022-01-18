package com.example.connector.vo.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lmt
 * @date 2021/9/26 15:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceRunDataPullVo {
    private long clientId;
    private Long time;
}
