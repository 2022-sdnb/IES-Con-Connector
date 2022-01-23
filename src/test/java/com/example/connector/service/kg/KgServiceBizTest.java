package com.example.connector.service.kg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.connector.bo.kg.KgDeviceInfoBo;
import com.example.connector.entity.kg.KgDeviceInfo;
import com.example.connector.repo.kg.KgDeviceInfoRepository;
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

    @Autowired KgServiceBiz service;

    @MockBean KgDeviceInfoRepository repository;

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
}
