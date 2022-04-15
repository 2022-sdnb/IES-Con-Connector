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
public class ChargerDeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private String wattCode;
    private String cdName;
    private String zdName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short zdFcode;
    private Short cdFcode;
    private String cdPid;
    private Short outCnt;
    private Short phaseCnt;
    private Float inUe;
    private Float inIe;
    private Float inPower;
    private Float outUe;
    private Float outIe;
    private Float outPower;
    private Integer datapoint;
    private String url;
    private Integer offlineCnt;
    private LocalDateTime onlineTime;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private Integer modifyCnt = 0;
    private String checkMan;
    private String authMan;
    private String zdPid;
    private String cdFile;
    private String zdPic;
    private Short state;
    private String remark;

    /** for test usage */
    public ChargerDeviceInfo(long id, int modifyCnt) {
        this.id = id;
        this.modifyCnt = modifyCnt;
    }
}
