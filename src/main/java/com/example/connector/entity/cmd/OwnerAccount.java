package com.example.connector.entity.cmd;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class OwnerAccount {
    @Id
    @Column(name = "ownerId", nullable = false)
    private Long id;

    private String pswMask;
    private String psw;
    private String type;
    private String cpyname;
    private String cpyaddr;
    private String cpyUsccq;
    private String ptcnameFirst;
    private String ptctelFirst;
    private String ptcnameSecond;
    private String ptctelSecond;
    private String ptcMail;
    private String profilePic;
    private String cpyBlFile;
    private String contractFile;
    private Short state;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private Integer modifyCnt;
    private String checkMan;
    private String authMan;
    private String remark;
}
