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
public class ChargerRunStateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Short cdState;
    private String cdMsg;
    private Short zdState;
    private String zdMsg;
    private Short cdFlag1;
    private Short cdFlag2;
    private Short cdFlag3;
    private Short cdFlag4;
    private Short state;
    private String remark;
}
