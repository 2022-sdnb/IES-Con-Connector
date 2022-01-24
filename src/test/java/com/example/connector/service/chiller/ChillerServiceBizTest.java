package com.example.connector.service.chiller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.connector.bo.chiller.ChillerDeviceInfoBo;
import com.example.connector.entity.chiller.ChillerDeviceInfo;
import com.example.connector.repo.chiller.ChillerDeviceInfoRepository;
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

    @Autowired ChillerServiceBiz service;

    @MockBean ChillerDeviceInfoRepository repository;

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
}
