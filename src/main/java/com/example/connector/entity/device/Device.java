package com.example.connector.entity.device;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id private Long id;

    private Long gatewayId;

    private String host;

    private Integer port;

    /** for test usage */
    public Device(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
