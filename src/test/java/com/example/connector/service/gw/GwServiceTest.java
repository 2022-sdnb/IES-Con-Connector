package com.example.connector.service.gw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.entity.gw.GwDeviceInfo;
import com.example.connector.repo.gw.GwDeviceInfoRepository;
import com.example.connector.vo.gw.GwDeviceInfoVo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class GwServiceTest {

    private final List<GwDeviceInfo> infos =
            Arrays.asList(
                    new GwDeviceInfo(1),
                    new GwDeviceInfo(2),
                    new GwDeviceInfo(3),
                    new GwDeviceInfo(4),
                    new GwDeviceInfo(5));

    private List<GwDeviceInfoVo> gwDeviceInfoVos =
            infos.stream().map(GwDeviceInfoVo::new).collect(Collectors.toList());

    @Autowired GwService service;

    @MockBean GwDeviceInfoRepository repository;

    @Test
    void getAllDeviceInfos() {
        Mockito.when(repository.findAll()).thenReturn(infos);

        List<GwDeviceInfoVo> actualVos = service.getAllDeviceInfos();
        for (int i = 0; i < infos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(gwDeviceInfoVos.get(i), actualVos.get(i));
        }
    }
}
