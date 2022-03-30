package com.example.connector.entity.kg;

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
public class KgRunOtherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Float freRt;
    private Float factor;
    private Integer ua;
    private Integer ub;
    private Integer uc;
    private Integer uo;
    private Integer ia;
    private Integer ib;
    private Integer ic;
    private Integer io;
    private Integer uab;
    private Integer ubc;
    private Integer uca;
    private Float uaThd;
    private Float ubThd;
    private Float ucThd;
    private Float iaThd;
    private Float ibThd;
    private Float icThd;
    private Short state;
    private String remark;

    /** for test usage */
    public KgRunOtherData(long deviceId) {
        this.deviceId = deviceId;
    }
}
