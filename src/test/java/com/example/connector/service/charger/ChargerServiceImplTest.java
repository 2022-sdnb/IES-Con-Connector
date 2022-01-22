package com.example.connector.service.charger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.connector.entity.charger.ChargerDeviceInfo;
import com.example.connector.repo.charger.ChargerDeviceInfoRepository;
import com.example.connector.vo.charger.ChargerDeviceInfoVo;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
    void updateDeviceInfo() {}
}
