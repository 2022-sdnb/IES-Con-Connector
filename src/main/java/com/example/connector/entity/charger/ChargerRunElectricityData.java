package com.example.connector.entity.charger;

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
@NoArgsConstructor
@AllArgsConstructor
public class ChargerRunElectricityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private LocalDateTime startTime;
    private Float pwatt1;
    private Float pwatt2;
    private Float pwatt3;
    private Float pwatt4;
    private Float income1;
    private Float income2;
    private Float income3;
    private Float income4;
    private Short state;
    private String remark;

    /** for test usage */
    public ChargerRunElectricityData(long deviceId) {
        this.deviceId = deviceId;
    }
}
