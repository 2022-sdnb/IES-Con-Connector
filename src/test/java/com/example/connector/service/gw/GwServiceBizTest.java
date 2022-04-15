package com.example.connector.service.gw;

import static org.junit.jupiter.api.Assertions.*;

import com.example.connector.bo.gw.GwDeviceInfoBo;
import com.example.connector.entity.gw.GwDeviceInfo;
import com.example.connector.repo.gw.GwDeviceInfoRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class GwServiceBizTest {

    static boolean updated = false;

    @Autowired GwServiceBiz serviceBiz;

    @MockBean GwDeviceInfoRepository repository;

    @Test
    void updateDeviceInfo() {
        LocalDateTime beforeUpdated = LocalDateTime.now();
        long id = 1;
        short gwFcode = 1;
        int genCnt = 0, loadCnt = 0, storageCnt = 0, chargerCnt = 0, datapoint = 0;
        Float genKw = 0.0f, loadKw = 0.0f, storageKw = 0.0f, chargerKw = 0.0f;
        GwDeviceInfoBo upd =
                new GwDeviceInfoBo(
                        id,
                        gwFcode,
                        genCnt,
                        genKw,
                        loadCnt,
                        loadKw,
                        storageCnt,
                        storageKw,
                        chargerCnt,
                        chargerKw,
                        datapoint);
        GwDeviceInfo target = new GwDeviceInfo(id);

        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(target));
        Mockito.doAnswer(
                        invocation -> {
                            updated = true;
                            return null;
                        })
                .when(repository)
                .save(target);

        serviceBiz.updateDeviceInfo(upd);

        Mockito.verify(repository, Mockito.atLeastOnce()).save(target);
        assertEquals(gwFcode, target.getGwFcode());
        assertEquals(genCnt, target.getGenCnt());
        assertEquals(genKw, target.getGenKw());
        assertEquals(loadCnt, target.getLoadCnt());
        assertEquals(loadKw, target.getLoadKw());
        assertEquals(storageCnt, target.getStorageCnt());
        assertEquals(storageKw, target.getStorageKw());
        assertEquals(chargerCnt, target.getChargerCnt());
        assertEquals(chargerKw, target.getChargerKw());
        assertEquals(datapoint, target.getDatapoint());
        assertTrue(beforeUpdated.isBefore(target.getModifyDate()));
        assertNull(target.getModifyCnt());
    }
}
