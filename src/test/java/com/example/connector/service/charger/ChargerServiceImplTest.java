package com.example.connector.service.charger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.bo.charger.ChargerDeviceInfoBo;
import com.example.connector.bo.charger.ChargerRunElectricityDataBo;
import com.example.connector.entity.charger.ChargerDeviceInfo;
import com.example.connector.entity.charger.ChargerRunElectricityData;
import com.example.connector.repo.charger.ChargerDeviceInfoRepository;
import com.example.connector.repo.charger.ChargerRunElectricityDataRepository;
import com.example.connector.vo.charger.ChargerDeviceInfoVo;
import com.example.connector.vo.charger.ChargerRunElectricityDataVo;
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

    // 初始化充电桩静态数据
    private final List<ChargerDeviceInfo> infos =
            Arrays.asList(
                    new ChargerDeviceInfo(6, 0),
                    new ChargerDeviceInfo(4, 0),
                    new ChargerDeviceInfo(2, 0),
                    new ChargerDeviceInfo(8, 0),
                    new ChargerDeviceInfo(9, 0));

    // 初始化充电桩交易数据
    private final List<ChargerRunElectricityData> datas =
            Arrays.asList(
                    new ChargerRunElectricityData(1),
                    new ChargerRunElectricityData(3),
                    new ChargerRunElectricityData(5));

    static int dataSize = 3;

    private List<ChargerDeviceInfoVo> infoVos;

    private List<ChargerRunElectricityDataVo> dataVos;

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
        dataVos =
                datas.stream()
                        .map(ChargerRunElectricityDataVo::fromEntity)
                        .collect(Collectors.toList());
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
            assertEquals(0, info.getModifyCnt());
        }
    }

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
        ChargerRunElectricityDataRepository repo =
                Mockito.mock(ChargerRunElectricityDataRepository.class);
        ChargerServiceImpl addService = new ChargerServiceImpl(repo);
        Mockito.doAnswer(
                        invocation -> {
                            dataSize++;
                            return null;
                        })
                .when(repo)
                .save(add.getEntity());

        addService.addRunElectricityData(add);

        Mockito.verify(repo, Mockito.atLeastOnce()).save(add.getEntity());
        assertEquals(previousSize + 1, dataSize);
    }

    @Test
    void getAllRunElectricityDatas1() {
        ChargerRunElectricityDataRepository repo =
                Mockito.mock(ChargerRunElectricityDataRepository.class);
        ChargerServiceImpl getService = new ChargerServiceImpl(repo);

        long deviceId = 1;
        Mockito.when(repo.findAll()).thenReturn(datas);

        List<ChargerRunElectricityDataVo> actualVos =
                getService.getAllRunElectricityDatas(deviceId);
        for (int i = 0; i < dataVos.size(); i++) {
            // 确保没有发生越界，否则说明获取的不全
            assertTrue(i < actualVos.size());
            assertEquals(dataVos.get(i), actualVos.get(i));
        }
    }
}
