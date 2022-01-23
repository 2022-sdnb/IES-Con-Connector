package com.example.connector.service.kg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.connector.entity.kg.KgDeviceInfo;
import com.example.connector.repo.kg.KgDeviceInfoRepository;
import com.example.connector.vo.kg.KgDeviceInfoVo;
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

    private final List<KgDeviceInfo> infos =
            Arrays.asList(
                    new KgDeviceInfo(1),
                    new KgDeviceInfo(2),
                    new KgDeviceInfo(4),
                    new KgDeviceInfo(6),
                    new KgDeviceInfo(7));

    private List<KgDeviceInfoVo> expectedVos =
            infos.stream().map(KgDeviceInfoVo::new).collect(Collectors.toList());

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
