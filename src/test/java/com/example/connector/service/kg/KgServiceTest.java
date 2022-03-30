package com.example.connector.service.kg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.entity.kg.*;
import com.example.connector.repo.kg.*;
import com.example.connector.vo.kg.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class KgServiceTest {

    @Autowired KgService service;

    @MockBean KgDeviceInfoRepository repository;

    @MockBean KgRunElectricityDataRepository runElectricityDataRepository;

    @MockBean KgRunOtherDataRepository runOtherDataRepository;

    @MockBean KgRunPowerDataRepository runPowerDataRepository;

    @MockBean KgRunStateDataRepository runStateDataRepository;

    private final List<KgDeviceInfo> infos =
            Arrays.asList(
                    new KgDeviceInfo(1),
                    new KgDeviceInfo(2),
                    new KgDeviceInfo(4),
                    new KgDeviceInfo(6),
                    new KgDeviceInfo(7));

    // 初始化负控设备运行时电力数据
    private final List<KgRunElectricityData> runElectricityDatas =
            Arrays.asList(
                    new KgRunElectricityData(2),
                    new KgRunElectricityData(3),
                    new KgRunElectricityData(5),
                    new KgRunElectricityData(7));

    // 初始化负控设备运行时其他数据
    private final List<KgRunOtherData> runOtherDatas =
            Arrays.asList(
                    new KgRunOtherData(1),
                    new KgRunOtherData(2),
                    new KgRunOtherData(3),
                    new KgRunOtherData(4),
                    new KgRunOtherData(5));

    // 初始化负控设备运行时能量数据
    private final List<KgRunPowerData> runPowerDatas =
            Arrays.asList(
                    new KgRunPowerData(1),
                    new KgRunPowerData(11),
                    new KgRunPowerData(21),
                    new KgRunPowerData(31));

    // 初始化负控设备状态数据
    private final List<KgRunStateData> runStateDatas =
            Arrays.asList(
                    new KgRunStateData(2),
                    new KgRunStateData(5),
                    new KgRunStateData(8),
                    new KgRunStateData(9));

    private List<KgDeviceInfoVo> expectedVos =
            infos.stream().map(KgDeviceInfoVo::new).collect(Collectors.toList());

    private List<KgRunElectricityDataVo> runElectricityDataVos =
            runElectricityDatas.stream()
                    .map(KgRunElectricityDataVo::new)
                    .collect(Collectors.toList());

    private List<KgRunOtherDataVo> runOtherDataVos =
            runOtherDatas.stream().map(KgRunOtherDataVo::new).collect(Collectors.toList());

    private List<KgRunPowerDataVo> runPowerDataVos =
            runPowerDatas.stream().map(KgRunPowerDataVo::new).collect(Collectors.toList());

    private List<KgRunStateDataVo> runStateDataVos =
            runStateDatas.stream().map(KgRunStateDataVo::new).collect(Collectors.toList());

    @Test
    void getAllDeviceInfos() {
        Mockito.when(repository.findAll()).thenReturn(infos);

        List<KgDeviceInfoVo> actualVos = service.getAllDeviceInfos();
        for (int i = 0; i < expectedVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(expectedVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunElectricityDatas() {
        long deviceId = 1;
        Mockito.when(runElectricityDataRepository.findAll()).thenReturn(runElectricityDatas);

        List<KgRunElectricityDataVo> actualVos = service.getAllRunElectricityDatas(deviceId);
        for (int i = 0; i < runElectricityDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(runElectricityDataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunDatas() {
        long deviceId = 1;
        Mockito.when(runOtherDataRepository.findAll()).thenReturn(runOtherDatas);

        List<KgRunOtherDataVo> actualVos = service.getAllRunOtherDatas(deviceId);
        for (int i = 0; i < runOtherDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(runOtherDataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunPowerDatas() {
        long deviceId = 1;
        Mockito.when(runPowerDataRepository.findAll()).thenReturn(runPowerDatas);

        List<KgRunPowerDataVo> actualVos = service.getAllRunPowerDatas(deviceId);
        for (int i = 0; i < runPowerDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(runPowerDataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunStateDatas() {
        long deviceId = 1;
        Mockito.when(runStateDataRepository.findAll()).thenReturn(runStateDatas);

        List<KgRunStateDataVo> actualVos = service.getAllRunStateDatas(deviceId);
        for (int i = 0; i < runStateDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(runStateDataVos.get(i), actualVos.get(i));
        }
    }
}
