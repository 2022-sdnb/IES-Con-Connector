package com.example.connector.service.kg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.entity.kg.KgDeviceInfo;
import com.example.connector.entity.kg.KgRunElectricityData;
import com.example.connector.repo.kg.*;
import com.example.connector.vo.kg.KgDeviceInfoVo;
import com.example.connector.vo.kg.KgRunElectricityDataVo;
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

    private List<KgDeviceInfoVo> expectedVos =
            infos.stream().map(KgDeviceInfoVo::new).collect(Collectors.toList());

    private List<KgRunElectricityDataVo> runElectricityDataVos =
            runElectricityDatas.stream()
                    .map(KgRunElectricityDataVo::new)
                    .collect(Collectors.toList());

    @Test
    void getAllDeviceInfos() {
        Mockito.when(repository.findAll()).thenReturn(infos);

        List<KgDeviceInfoVo> actualVos = service.getAllDeviceInfos();
        for (int i = 0; i < expectedVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(expectedVos.get(i), actualVos.get(i));
        }
    }
}
