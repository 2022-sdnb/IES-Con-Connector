package com.example.connector.entity.cmd;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class ManagerAccount {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String pswMask;
    private String psw;
    private String type;
    private String name;
    private String department;
    private String title;
    private String staffTel;
    private String staffMail;
    private String profilePic;
    private Short state;
    private String remark;
}
