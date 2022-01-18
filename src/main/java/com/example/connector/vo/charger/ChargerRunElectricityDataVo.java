package com.example.connector.vo.charger;

import com.example.connector.entity.charger.ChargerRunElectricityData;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lmt
 * @date 2021/10/10 13:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargerRunElectricityDataVo {
    private Long id;

    private Long deviceId;

    private LocalDateTime time;

    private LocalDateTime startTime;
    private Float pwatt1;
    private Float pwatt2;
    private Float pwatt3;
    private Float pwatt4;
    private Float income1;
    private Float income2;
    private Float income3;
    private Float income4;
    private Short state;
    private String remark;

    public ChargerRunElectricityDataVo(ChargerRunElectricityData data) {
        id = data.getId();
        deviceId = data.getDeviceId();
        time = data.getTime();
        startTime = data.getStartTime();
        pwatt1 = data.getPwatt1();
        pwatt2 = data.getPwatt2();
        pwatt3 = data.getPwatt3();
        pwatt4 = data.getPwatt4();
        income1 = data.getIncome1();
        income2 = data.getIncome2();
        income3 = data.getIncome3();
        income4 = data.getIncome4();
        state = data.getState();
        remark = data.getRemark();
    }
}
