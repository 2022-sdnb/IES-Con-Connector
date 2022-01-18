package com.example.connector.vo.device;

import com.example.connector.entity.device.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceVo {
    /** 设备唯一识别码，发送注册请求时分配 */
    Long id;

    /** 网关 ID */
    private long gatewayId;

    /** IP */
    private String host;

    /** 端口 */
    private Integer port;

    public DeviceVo(Device device) {
        this.id = device.getId();
        this.host = device.getHost();
        this.port = device.getPort();
    }
}
