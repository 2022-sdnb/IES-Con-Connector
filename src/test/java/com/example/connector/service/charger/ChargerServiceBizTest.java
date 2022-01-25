package com.example.connector.service.charger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.connector.bo.charger.ChargerDeviceInfoBo;
import com.example.connector.bo.charger.ChargerRunElectricityDataBo;
import com.example.connector.entity.charger.ChargerDeviceInfo;
import com.example.connector.repo.charger.ChargerDeviceInfoRepository;
import com.example.connector.repo.charger.ChargerRunElectricityDataRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ChargerServiceBizTest {

    private List<ChargerDeviceInfo> infos = List.of(new ChargerDeviceInfo(1, 0));

    static int dataSize = 1;

    @MockBean private ChargerDeviceInfoRepository deviceInfoRepository;

    @MockBean private ChargerRunElectricityDataRepository runElectricityDataRepository;

    @Autowired private ChargerServiceBiz service;

    @Test
    void addRunElectricityData() {
        long deviceId = 2;
        long time = 10, startTime = 10;
        float pwatt1 = 1.0f, pwatt2 = 2.0f, pwatt3 = 3.0f, pwatt4 = 4.0f;
        float income1 = 1.0f, income2 = 2.0f, income3 = 3.0f, income4 = 4.0f;
        ChargerRunElectricityDataBo add =
                new ChargerRunElectricityDataBo(
                        deviceId, time, startTime, pwatt1, pwatt2, pwatt3, pwatt4, income1, income2,
                        income3, income4);

        int previousSize = dataSize;
        Mockito.doAnswer(
                        invocation -> {
                            dataSize++;
                            return null;
                        })
                .when(runElectricityDataRepository)
                .save(add.getEntity());

        service.addRunElectricityData(add);

        Mockito.verify(runElectricityDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, dataSize);
    }

    @Test
    void updateDeviceInfo1() {
        infos.get(0).setModifyCnt(0);

        long updateId = 2;
        short zdFcode = 1, cdFcode = 1;
        String cdPid = "test";
        short outCnt = 5, phaseCnt = 5;
        float inUe = 3.0f, inIe = 3.0f, inPower = 6.0f;
        float outUe = 2.5f, outIe = 2.5f, outPower = 5.0f;
        int datapoint = 1;
        ChargerDeviceInfoBo update =
                new ChargerDeviceInfoBo(
                        updateId, zdFcode, cdFcode, cdPid, outCnt, phaseCnt, inUe, inIe, inPower,
                        outUe, outIe, outPower, datapoint);

        Mockito.when(deviceInfoRepository.findById(updateId)).thenReturn(Optional.of(infos.get(0)));
        Mockito.when(deviceInfoRepository.save(infos.get(0))).thenReturn(infos.get(0));

        service.updateDeviceInfo(update);

        assertEquals(cdPid, infos.get(0).getCdPid());
        assertEquals(1, infos.get(0).getModifyCnt());
    }

    @Test
    void updateDeviceInfo2() {
        long updateId = 1;

        ChargerDeviceInfoBo failed = Mockito.mock(ChargerDeviceInfoBo.class);
        Mockito.when(deviceInfoRepository.findById(updateId)).thenReturn(Optional.empty());

        service.updateDeviceInfo(failed);

        // 验证确实没有调用update方法，也就是在调用前就捕捉到null并返回
        for (ChargerDeviceInfo info : infos) {
            Mockito.verify(failed, Mockito.never()).updateEntity(info);
            assertEquals(0, info.getModifyCnt());
        }
    }
}