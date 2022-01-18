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
public class ChillerRunData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Float pwatt;
    private Float qwatt;
    private Float chInTemp;
    private Float chOutTemp;
    private Float coInTemp;
    private Float coOutTemp;
    private Float evaTemp;
    private Float conTemp;
    private Float evaPressure;
    private Float conPressure;
    private Short state;
    private String remark;
}
