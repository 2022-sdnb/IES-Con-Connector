package com.example.connector.service.charger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.entity.charger.ChargerDeviceInfo;
import com.example.connector.entity.charger.ChargerRunElectricityData;
import com.example.connector.repo.charger.ChargerDeviceInfoRepository;
import com.example.connector.repo.charger.ChargerRunElectricityDataRepository;
import com.example.connector.vo.charger.ChargerDeviceInfoVo;
import com.example.connector.vo.charger.ChargerRunElectricityDataVo;
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

    private List<ChargerDeviceInfoVo> infoVos =
            infos.stream().map(ChargerDeviceInfoVo::fromEntity).collect(Collectors.toList());

    private List<ChargerRunElectricityDataVo> dataVos =
            datas.stream()
                    .map(ChargerRunElectricityDataVo::fromEntity)
                    .collect(Collectors.toList());

    @MockBean private ChargerDeviceInfoRepository deviceInfoRepository;

    @MockBean private ChargerRunElectricityDataRepository runElectricityDataRepository;

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
}
