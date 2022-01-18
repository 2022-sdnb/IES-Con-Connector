package com.example.connector.entity.kg;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(indexes = {@Index(columnList = "deviceId")})
@Data
@NoArgsConstructor
public class KgDeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private String wattCode;
    private Integer loadtype;
    private String kgName;
    private String zdName;
    private String addr;
    private String region;
    private String lon;
    private String lat;
    private Short zdFcode;
    private String kgType;
    private Short phaseCnt;
    private Float ue;
    private Float umax;
    private Float ie;
    private Float imax;
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
    private String kgFile;
    private String zdPic;
    private Short state;
    private String remark;
}
