package com.example.connector.service.chiller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.connector.entity.chiller.*;
import com.example.connector.repo.chiller.*;
import com.example.connector.vo.chiller.ChillerDeviceInfoVo;
import com.example.connector.vo.chiller.ChillerRunDataVo;
import com.example.connector.vo.chiller.ChillerRunPowerDataVo;
import com.example.connector.vo.chiller.ChillerRunStateDataVo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ChillerServiceTest {

    @Autowired ChillerService service;

    @MockBean ChillerDeviceInfoRepository repository;

    @MockBean ChillerRunDataRepository runDataRepository;

    @MockBean ChillerRunPowerDataRepository runPowerDataRepository;

    @MockBean ChillerRunStateDataRepository runStateDataRepository;

    private final List<ChillerDeviceInfo> infos =
            Arrays.asList(
                    new ChillerDeviceInfo(2),
                    new ChillerDeviceInfo(4),
                    new ChillerDeviceInfo(6),
                    new ChillerDeviceInfo(7),
                    new ChillerDeviceInfo(8));

    // 初始化空调动态数据
    private final List<ChillerRunData> runDatas =
            Arrays.asList(
                    new ChillerRunData(0),
                    new ChillerRunData(2),
                    new ChillerRunData(8),
                    new ChillerRunData(16));

    // 初始化空调动态能量数据
    private final List<ChillerRunPowerData> runPowerDatas =
            Arrays.asList(
                    new ChillerRunPowerData(1),
                    new ChillerRunPowerData(5),
                    new ChillerRunPowerData(7),
                    new ChillerRunPowerData(9));

    // 初始化空调动态日程数据
    private final List<ChillerRunStateData> runStateDatas =
            Arrays.asList(
                    new ChillerRunStateData(1),
                    new ChillerRunStateData(14),
                    new ChillerRunStateData(21),
                    new ChillerRunStateData(22),
                    new ChillerRunStateData(34));

    private List<ChillerDeviceInfoVo> expectedVos =
            infos.stream().map(ChillerDeviceInfoVo::new).collect(Collectors.toList());

    private List<ChillerRunDataVo> runDataVos =
            runDatas.stream().map(ChillerRunDataVo::new).collect(Collectors.toList());

    private List<ChillerRunPowerDataVo> runPowerDataVos =
            runPowerDatas.stream().map(ChillerRunPowerDataVo::new).collect(Collectors.toList());

    private List<ChillerRunStateDataVo> runStateDataVos =
            runStateDatas.stream().map(ChillerRunStateDataVo::new).collect(Collectors.toList());

    @Test
    void getAllDeviceInfos() {
        Mockito.when(repository.findAll()).thenReturn(infos);

        List<ChillerDeviceInfoVo> actualVos = service.getAllDeviceInfos();
        for (int i = 0; i < expectedVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(expectedVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunDatas() {
        long deviceId = 1;
        Mockito.when(runDataRepository.findAll()).thenReturn(runDatas);

        List<ChillerRunDataVo> actualVos = service.getAllRunOtherDatas(deviceId);
        for (int i = 0; i < runDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(runDataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunPowerDatas() {
        long deviceId = 1;
        Mockito.when(runPowerDataRepository.findAll()).thenReturn(runPowerDatas);

        List<ChillerRunPowerDataVo> actualVos = service.getAllRunPowerDatas(deviceId);
        for (int i = 0; i < runPowerDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(runPowerDataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunStateDatas() {
        long deviceId = 1;
        Mockito.when(runStateDataRepository.findAll()).thenReturn(runStateDatas);

        List<ChillerRunStateDataVo> actualVos = service.getAllRunStateDatas(deviceId);
        for (int i = 0; i < runStateDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(runStateDataVos.get(i), actualVos.get(i));
        }
    }
}
