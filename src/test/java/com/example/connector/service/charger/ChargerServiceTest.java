package com.example.connector.service.charger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.entity.charger.*;
import com.example.connector.repo.charger.*;
import com.example.connector.vo.charger.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ChargerServiceTest {

    // 初始化充电桩静态数据
    private final List<ChargerDeviceInfo> infos =
            Arrays.asList(
                    new ChargerDeviceInfo(2, 0),
                    new ChargerDeviceInfo(4, 0),
                    new ChargerDeviceInfo(6, 0),
                    new ChargerDeviceInfo(7, 0),
                    new ChargerDeviceInfo(8, 0));

    // 初始化充电桩交易数据
    private final List<ChargerRunElectricityData> datas =
            Arrays.asList(
                    new ChargerRunElectricityData(1),
                    new ChargerRunElectricityData(3),
                    new ChargerRunElectricityData(5));

    // 初始化充电桩其它运行时数据
    private final List<ChargerRunOtherData> otherDatas =
            Arrays.asList(
                    new ChargerRunOtherData(1),
                    new ChargerRunOtherData(2),
                    new ChargerRunOtherData(3),
                    new ChargerRunOtherData(4));

    // 初始化充电桩能量数据
    private final List<ChargerRunPowerData> powerDatas =
            Arrays.asList(
                    new ChargerRunPowerData(1),
                    new ChargerRunPowerData(9),
                    new ChargerRunPowerData(19),
                    new ChargerRunPowerData(29));

    // 初始化充电桩运行状态数据
    private final List<ChargerRunStateData> stateDatas =
            Arrays.asList(
                    new ChargerRunStateData(9),
                    new ChargerRunStateData(5),
                    new ChargerRunStateData(2),
                    new ChargerRunStateData(7));

    private List<ChargerDeviceInfoVo> infoVos =
            infos.stream().map(ChargerDeviceInfoVo::fromEntity).collect(Collectors.toList());

    private List<ChargerRunElectricityDataVo> dataVos =
            datas.stream()
                    .map(ChargerRunElectricityDataVo::fromEntity)
                    .collect(Collectors.toList());

    private List<ChargerRunOtherDataVo> otherDataVos =
            otherDatas.stream().map(ChargerRunOtherDataVo::fromEntity).collect(Collectors.toList());

    private List<ChargerRunPowerDataVo> powerDataVos =
            powerDatas.stream().map(ChargerRunPowerDataVo::fromEntity).collect(Collectors.toList());

    private List<ChargerRunStateDataVo> stateDataVos =
            stateDatas.stream().map(ChargerRunStateDataVo::fromEntity).collect(Collectors.toList());

    @MockBean private ChargerDeviceInfoRepository deviceInfoRepository;

    @MockBean private ChargerRunElectricityDataRepository runElectricityDataRepository;

    @MockBean private ChargerRunOtherDataRepository runOtherDataRepository;

    @MockBean private ChargerRunPowerDataRepository runPowerDataRepository;

    @MockBean private ChargerRunStateDataRepository runStateDataRepository;

    @Autowired private ChargerService service;

    @Test
    void getAllDeviceInfos() {
        Mockito.when(deviceInfoRepository.findAll()).thenReturn(infos);

        List<ChargerDeviceInfoVo> actualVos = service.getAllDeviceInfos();

        for (int i = 0; i < infos.size(); i++) {
            // 确保没有发生越界，否则说明获取的不全
            assertTrue(i < actualVos.size());
            assertEquals(infoVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunElectricityDatas() {
        long deviceId = 1;
        Mockito.when(runElectricityDataRepository.findAll()).thenReturn(datas);

        List<ChargerRunElectricityDataVo> actualVos = service.getAllRunElectricityDatas(deviceId);
        for (int i = 0; i < dataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(dataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunOtherDatas() {
        long deviceId = 1;
        Mockito.when(runOtherDataRepository.findAll()).thenReturn(otherDatas);

        List<ChargerRunOtherDataVo> actualVos = service.getAllRunOtherDatas(deviceId);
        for (int i = 0; i < otherDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(otherDataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunPowerDatas() {
        long deviceId = 1;
        Mockito.when(runPowerDataRepository.findAll()).thenReturn(powerDatas);

        List<ChargerRunPowerDataVo> actualVos = service.getAllRunPowerDatas(deviceId);
        for (int i = 0; i < powerDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(powerDataVos.get(i), actualVos.get(i));
        }
    }

    @Test
    void getAllRunStateDatas() {
        long deviceId = 0;
        Mockito.when(runStateDataRepository.findAll()).thenReturn(stateDatas);

        List<ChargerRunStateDataVo> actualVos = service.getAllRunStateDatas(deviceId);
        for (int i = 0; i < stateDataVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(stateDataVos.get(i), actualVos.get(i));
        }
    }
}
