package com.example.connector.entity.chiller;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(indexes = {@Index(columnList = "deviceId")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChillerRunPowerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Float pRt;
    private Float qRt;
    private Short state;
    private String remark;

    /** for test usage */
    public ChillerRunPowerData(long deviceId) {
        this.deviceId = deviceId;
    }
}
