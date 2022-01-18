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
public class ChillerRunStateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Short ktState;
    private String ktMsg;
    private Short zdState;
    private String zdMsg;
    private Short localState;
    private Short refStatus;
    private Short evaState;
    private Short conState;
    private Integer comStartsCnt;
    private Long runTime;
    private Short state;
    private String remark;
}
