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
public class ChargerRunOtherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Float factor;
    private Float ua;
    private Float ub;
    private Float uc;
    private Float uo;
    private Float ia;
    private Float ib;
    private Float ic;
    private Float io;
    private Float uab;
    private Float ubc;
    private Float uca;
    private Float uaThd;
    private Float ubThd;
    private Float ucThd;
    private Float iaThd;
    private Float ibThd;
    private Float icThd;
    private Short state;
    private String remark;
}
