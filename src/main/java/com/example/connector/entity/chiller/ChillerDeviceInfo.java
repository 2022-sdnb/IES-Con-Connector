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
@NoArgsConstructor
@AllArgsConstructor
public class ChillerDeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private String wattCode;
    private String ktName;
    private String zdName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short ktFcode;
    private String ktPid;
    private Float capCool;
    private Float capHeat;
    private Float istart;
    private Float imax;
    private Float imin;
    private Float ibreak;
    private Float uin;
    private Short phaseCnt;
    private Integer datapoint;
    private String url;
    private Integer offlineCnt;
    private LocalDateTime onlineTime;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private Integer modifyCnt;
    private String checkMan;
    private String authMan;
    private String zdPid;
    private String ktFile;
    private String zdPic;
    private Short state;
    private String remark;

    /** for test usage */
    public ChillerDeviceInfo(long deviceId) {
        this.deviceId = deviceId;
    }
}
