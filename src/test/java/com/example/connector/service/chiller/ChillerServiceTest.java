package com.example.connector.service.chiller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.connector.entity.chiller.ChillerDeviceInfo;
import com.example.connector.repo.chiller.ChillerDeviceInfoRepository;
import com.example.connector.vo.chiller.ChillerDeviceInfoVo;
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

    private final List<ChillerDeviceInfo> infos =
            Arrays.asList(
                    new ChillerDeviceInfo(2),
                    new ChillerDeviceInfo(4),
                    new ChillerDeviceInfo(6),
                    new ChillerDeviceInfo(7),
                    new ChillerDeviceInfo(8));

    private List<ChillerDeviceInfoVo> expectedVos =
            infos.stream().map(ChillerDeviceInfoVo::new).collect(Collectors.toList());

    @Test
    void getAllDeviceInfos() {
        Mockito.when(repository.findAll()).thenReturn(infos);

        List<ChillerDeviceInfoVo> actualVos = service.getAllDeviceInfos();
        for (int i = 0; i < expectedVos.size(); i++) {
            assertTrue(i < actualVos.size());
            assertEquals(expectedVos.get(i), actualVos.get(i));
        }
    }
}
