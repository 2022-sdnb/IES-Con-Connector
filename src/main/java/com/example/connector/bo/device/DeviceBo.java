package com.example.connector.bo.device;

import com.example.connector.entity.device.Device;
import java.net.InetSocketAddress;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceBo {
    /** 设备唯一识别码，发送注册请求时分配 */
    private final long id;

    /** 网关 ID */
    private final long gatewayId;

    /** IP 与 端口 */
    private final InetSocketAddress addr;

    public DeviceBo(Device device) {
        this.id = device.getId();
        this.gatewayId = device.getGatewayId();
        this.addr = new InetSocketAddress(device.getHost(), device.getPort());
    }

    public Device getEntity() {
        return new Device(id, gatewayId, addr.getHostName(), addr.getPort());
    }
}
