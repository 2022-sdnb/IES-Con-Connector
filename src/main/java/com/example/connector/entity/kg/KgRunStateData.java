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
public class KgRunStateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime time;
    private Short kgState;
    private String kgMsg;
    private Short zdState;
    private String zdMsg;
    private Short state;
    private String remark;

    /** for test usage */
    public KgRunStateData(long deviceId) {
        this.deviceId = deviceId;
    }
}
