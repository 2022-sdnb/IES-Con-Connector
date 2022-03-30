package com.example.connector.service.chiller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.connector.bo.chiller.*;
import com.example.connector.entity.chiller.ChillerDeviceInfo;
import com.example.connector.repo.chiller.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ChillerServiceBizTest {

    private List<ChillerDeviceInfo> infos = List.of(new ChillerDeviceInfo(5));

    static int runDataSize = 1;

    static int runPowerDataSize = 1;

    static int runScheduleDataSize = 1;

    static int runStateDataSize = 1;

    @Autowired ChillerServiceBiz service;

    @MockBean ChillerDeviceInfoRepository repository;

    @MockBean ChillerRunDataRepository runDataRepository;

    @MockBean ChillerRunPowerDataRepository runPowerDataRepository;

    @MockBean ChillerRunScheduleDataRepository runScheduleDataRepository;

    @MockBean ChillerRunStateDataRepository runStateDataRepository;

    @Test
    void updateDeviceInfo1() {
        infos.get(0).setModifyCnt(0);

        long id = 5;
        short ktFcode = 0, phaseCnt = 0;
        String ktPid = "test";
        float capCool = 0.0f,
                capHeat = 0.0f,
                iStart = 0.0f,
                iMax = 100.0f,
                iMin = 50.0f,
                iBreak = 0.0f,
                uIn = 1.0f;
        int dataPoint = 1;
        ChillerDeviceInfoBo update =
                new ChillerDeviceInfoBo(
                        id, ktFcode, ktPid, capCool, capHeat, iStart, iMax, iMin, iBreak, uIn,
                        phaseCnt, dataPoint);

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(infos.get(0)));
        Mockito.when(repository.save(infos.get(0))).thenReturn(infos.get(0));

        service.updateDeviceInfo(update);

        assertEquals(ktPid, infos.get(0).getKtPid());
        assertEquals(1, infos.get(0).getModifyCnt());
    }

    @Test
    void updateDeviceInfo2() {
        for (ChillerDeviceInfo info : infos) {
            info.setModifyCnt(0);
        }

        long updateId = 0;

        ChillerDeviceInfoBo failed = Mockito.mock(ChillerDeviceInfoBo.class);
        Mockito.when(repository.findById(updateId)).thenReturn(Optional.empty());

        service.updateDeviceInfo(failed);

        for (ChillerDeviceInfo info : infos) {
            Mockito.verify(failed, Mockito.never()).updateEntity(info);
            assertEquals(0, info.getModifyCnt());
        }
    }

    @Test
    void addRunData() {
        long deviceId = 23, time = 2;
        float pwatt = 0.0f,
                qwatt = 0.0f,
                chInTemp = 8.0f,
                chOutTemp = 24.0f,
                coIntemp = 23.0f,
                coOutTemp = 33.0f,
                evaTemp = 8.0f,
                conTemp = 32.0f,
                evaPressure = 12.0f,
                conPressure = 32.0f;
        ChillerRunDataBo add =
                new ChillerRunDataBo(
                        deviceId,
                        time,
                        pwatt,
                        qwatt,
                        chInTemp,
                        chOutTemp,
                        coIntemp,
                        coOutTemp,
                        evaTemp,
                        conTemp,
                        evaPressure,
                        conPressure);

        int previousSize = runDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            runDataSize++;
                            return null;
                        })
                .when(runDataRepository)
                .save(add.getEntity());

        service.addRunData(add);

        Mockito.verify(runDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, runDataSize);
    }

    @Test
    void addRunPowerData() {
        long deviceId = 35, time = 13;
        float pRt = 0.0f, qRt = 1.2f;
        ChillerRunPowerDataBo add = new ChillerRunPowerDataBo(deviceId, time, pRt, qRt);

        int previousSize = runPowerDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            runPowerDataSize++;
                            return null;
                        })
                .when(runPowerDataRepository)
                .save(add.getEntity());

        service.addRunPowerData(add);

        Mockito.verify(runPowerDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, runPowerDataSize);
    }

    @Test
    void addRunScheduleData() {
        long deviceId = 34, time = 22;
        short onOffSet = 21;
        float temSet = 1.1f, pLimitSet = 1.7f;
        ChillerRunScheduleDataBo add =
                new ChillerRunScheduleDataBo(deviceId, time, onOffSet, temSet, pLimitSet);

        int previousSize = runScheduleDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            runScheduleDataSize++;
                            return null;
                        })
                .when(runScheduleDataRepository)
                .save(add.getEntity());

        service.addRunScheduleData(add);

        Mockito.verify(runScheduleDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, runScheduleDataSize);
    }

    @Test
    void addRunStateData() {
        long deviceId = 30, time = 23;
        short ktState = 11, zdState = 22;
        String ktMsg = "kt-test", zdMsg = "zd-test";
        short localState = 0, refStatus = 27, evaState = 14, conState = 18;
        int comStartsCnt = 1;
        long runTime = 10000;
        ChillerRunStateDataBo add =
                new ChillerRunStateDataBo(
                        deviceId,
                        time,
                        ktState,
                        ktMsg,
                        zdState,
                        zdMsg,
                        localState,
                        refStatus,
                        evaState,
                        conState,
                        comStartsCnt,
                        runTime);

        int previousSize = runStateDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            runStateDataSize++;
                            return null;
                        })
                .when(runStateDataRepository)
                .save(add.getEntity());

        service.addRunStateData(add);

        Mockito.verify(runStateDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, runStateDataSize);
    }
}
