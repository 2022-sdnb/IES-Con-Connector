package com.example.connector.entity.gw;

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
public class GwDeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private String gwposName;
    private String gwName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short gwFcode;
    private Integer genCnt;
    private Float genKw;
    private Integer loadCnt;
    private Float loadKw;
    private Integer storageCnt;
    private Float storageKw;
    private Integer chargerCnt;
    private Float chargerKw;
    private Integer datapoint;
    private String url;
    private Integer offlineCnt;
    private LocalDateTime onlineTime;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private Integer modifyCnt;
    private String checkMan;
    private String authMan;
    private String gwPid;
    private String gwPic;
    private Short state;
    private String remark;

    /** for test usage */
    public GwDeviceInfo(long deviceId) {
        this.deviceId = deviceId;
    }
}
