package com.example.connector.service.kg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.connector.bo.kg.*;
import com.example.connector.entity.kg.KgDeviceInfo;
import com.example.connector.repo.kg.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class KgServiceBizTest {

    private List<KgDeviceInfo> infos = List.of(new KgDeviceInfo(100));

    static int runElectricityDataSize = 1;

    static int runDataSize = 1;

    static int powerDataSize = 1;

    static int stateDataSize = 1;

    @Autowired KgServiceBiz service;

    @MockBean KgDeviceInfoRepository repository;

    @MockBean private KgRunElectricityDataRepository runElectricityDataRepository;

    @MockBean private KgRunOtherDataRepository runOtherDataRepository;

    @MockBean private KgRunPowerDataRepository runPowerDataRepository;

    @MockBean private KgRunStateDataRepository runStateDataRepository;

    @Test
    void updateDeviceInfo1() {
        // 初始化修改次数为0，因为该字段未在初始化时赋值
        infos.get(0).setModifyCnt(0);

        long id = 100;
        short zdFcode = 1, phaseCnt = 1;
        String kgType = "test";
        float ue = 2.5f, umax = 3.0f, ie = 2.5f, imax = 3.0f;
        int datapoint = 1;
        KgDeviceInfoBo update =
                new KgDeviceInfoBo(id, zdFcode, kgType, phaseCnt, ue, umax, ie, imax, datapoint);

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(infos.get(0)));
        Mockito.when(repository.save(infos.get(0))).thenReturn(infos.get(0));

        service.updateDeviceInfo(update);

        assertEquals(kgType, infos.get(0).getKgType());
        assertEquals(1, infos.get(0).getModifyCnt());
    }

    @Test
    void updateDeviceInfo2() {
        for (KgDeviceInfo info : infos) {
            info.setModifyCnt(0);
        }

        long updateId = 99;

        KgDeviceInfoBo failed = Mockito.mock(KgDeviceInfoBo.class);
        Mockito.when(repository.findById(updateId)).thenReturn(Optional.empty());

        service.updateDeviceInfo(failed);

        // 验证确实没有调用update方法，也就是在调用前就捕捉到null并返回
        for (KgDeviceInfo info : infos) {
            Mockito.verify(failed, Mockito.never()).updateEntity(info);
            assertEquals(0, info.getModifyCnt());
        }
    }

    @Test
    void addRunElectricityData() {
        long deviceId = 1, time = 2;
        float pwatt = 3.0f, qwatt = 4.0f;
        KgRunElectricityDataBo add = new KgRunElectricityDataBo(deviceId, time, pwatt, qwatt);

        int previousSize = runElectricityDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            runElectricityDataSize++;
                            return null;
                        })
                .when(runElectricityDataRepository)
                .save(add.getEntity());

        service.addRunElectricityData(add);

        Mockito.verify(runElectricityDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, runElectricityDataSize);
    }

    @Test
    void addRunOtherData() {
        long deviceId = 2, time = 10;
        float freRt = 0.0f,
                factor = 1.0f,
                uaThd = 0.0f,
                ubThd = 0.0f,
                ucThd = 0.0f,
                iaThd = 1.0f,
                ibThd = 1.0f,
                icThd = 1.0f;
        int ua = 2,
                ub = 3,
                uc = 4,
                uo = 5,
                ia = 6,
                ib = 7,
                ic = 8,
                io = 9,
                uab = 1,
                ubc = 1,
                uca = -2;
        KgRunOtherDataBo add =
                new KgRunOtherDataBo(
                        deviceId, time, freRt, factor, ua, ub, uc, uo, ia, ib, ic, io, uab, ubc,
                        uca, uaThd, ubThd, ucThd, iaThd, ibThd, icThd);

        int previousSize = runDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            runDataSize++;
                            return null;
                        })
                .when(runOtherDataRepository)
                .save(add.getEntity());

        service.addRunOtherData(add);

        Mockito.verify(runOtherDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, runDataSize);
    }

    @Test
    void addRunPowerData() {
        long deviceId = 0, time = 3;
        float pinRt = 2.3f, qinRt = 2.4f;
        KgRunPowerDataBo add = new KgRunPowerDataBo(deviceId, time, pinRt, qinRt);

        int previousSize = powerDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            powerDataSize++;
                            return null;
                        })
                .when(runPowerDataRepository)
                .save(add.getEntity());

        service.addRunPowerData(add);

        Mockito.verify(runPowerDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, powerDataSize);
    }

    @Test
    void addRunStateData() {
        long deviceId = 0, time = 4;
        short cdState = 1, zdState = 2;
        String cdMsg = "cd-test", zdMsg = "zd-test";
        KgRunStateDataBo add = new KgRunStateDataBo(deviceId, time, cdState, cdMsg, zdState, zdMsg);

        int previousSize = stateDataSize;
        Mockito.doAnswer(
                        invocation -> {
                            stateDataSize++;
                            return null;
                        })
                .when(runStateDataRepository)
                .save(add.getEntity());

        service.addRunStateData(add);

        Mockito.verify(runStateDataRepository, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, stateDataSize);
    }
}
