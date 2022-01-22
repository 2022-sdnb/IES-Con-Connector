package com.example.connector.service.charger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.connector.bo.charger.ChargerDeviceInfoBo;
import com.example.connector.entity.charger.ChargerDeviceInfo;
import com.example.connector.repo.charger.ChargerDeviceInfoRepository;
import com.example.connector.vo.charger.ChargerDeviceInfoVo;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@Slf4j
@SpringBootTest
class ChargerServiceImplTest {

    private final List<ChargerDeviceInfo> infos =
            Arrays.asList(
                    new ChargerDeviceInfo(6),
                    new ChargerDeviceInfo(4),
                    new ChargerDeviceInfo(2),
                    new ChargerDeviceInfo(8),
                    new ChargerDeviceInfo(9));

    private List<ChargerDeviceInfoVo> infoVos;

    @MockBean private ChargerDeviceInfoRepository repository;

    @Autowired private ChargerService service;

    @Autowired private ChargerServiceBiz serviceBiz;

    @BeforeEach
    void setUp() {
        Collections.sort(
                infos,
                new Comparator<ChargerDeviceInfo>() {
                    @Override
                    public int compare(ChargerDeviceInfo o1, ChargerDeviceInfo o2) {
                        return o1.getId().intValue() - o2.getId().intValue();
                    }
                });
        infoVos = infos.stream().map(ChargerDeviceInfoVo::fromEntity).collect(Collectors.toList());
    }

    @AfterEach
    void tearDown() {}

    @Test
    void getAllDeviceInfos() {
        Mockito.when(repository.findAll()).thenReturn(infos);

        List<ChargerDeviceInfoVo> actualVos = service.getAllDeviceInfos();
        Collections.sort(
                actualVos,
                new Comparator<ChargerDeviceInfoVo>() {
                    @Override
                    public int compare(ChargerDeviceInfoVo o1, ChargerDeviceInfoVo o2) {
                        return o1.getId().intValue() - o2.getId().intValue();
                    }
                });

        for (int i = 0; i < infos.size(); i++) {
            assertEquals(infoVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void updateDeviceInfo1() {
        infos.get(0).setModifyCnt(0);

        long updateId = 2;
        short zdFcode = 1, cdFcode = 1;
        String cdPid = "updated";
        short outCnt = 5, phaseCnt = 5;
        float inUe = 3.0f, inIe = 3.0f, inPower = 6.0f;
        float outUe = 2.5f, outIe = 2.5f, outPower = 5.0f;
        int datapoint = 1;
        ChargerDeviceInfoBo update =
                new ChargerDeviceInfoBo(
                        updateId, zdFcode, cdFcode, cdPid, outCnt, phaseCnt, inUe, inIe, inPower,
                        outUe, outIe, outPower, datapoint);

        Mockito.when(repository.findById(updateId)).thenReturn(Optional.of(infos.get(0)));
        Mockito.when(repository.save(infos.get(0))).thenReturn(infos.get(0));

        serviceBiz.updateDeviceInfo(update);

        assertEquals(cdPid, infos.get(0).getCdPid());
        assertEquals(1, infos.get(0).getModifyCnt());
    }

    @Test
    void updateDeviceInfo2() {
        long updateId = 1;

        ChargerDeviceInfoBo failed = Mockito.mock(ChargerDeviceInfoBo.class);
        Mockito.when(repository.findById(updateId)).thenReturn(Optional.empty());

        serviceBiz.updateDeviceInfo(failed);

        // 验证确实没有调用update方法，也就是在调用前就捕捉到null并返回
        for (ChargerDeviceInfo info : infos) {
            Mockito.verify(failed, Mockito.never()).updateEntity(info);
        }
        assertEquals(2, infos.get(0).getId());
    }
}
