package com.example.connector.service.gw;

import com.example.connector.bo.gw.GwDeviceInfoBo;
import com.example.connector.entity.gw.GwDeviceInfo;
import com.example.connector.repo.gw.GwDeviceInfoRepository;
import com.example.connector.vo.gw.GwDeviceInfoVo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GwServiceImpl implements GwService, GwServiceBiz {
    @Autowired GwDeviceInfoRepository repository;

    @Override
    public List<GwDeviceInfoVo> getAllDeviceInfos() {
        return repository.findAll().stream().map(GwDeviceInfoVo::new).collect(Collectors.toList());
    }

    @Override
    public void updateDeviceInfo(GwDeviceInfoBo bo) {
        GwDeviceInfo deviceInfo = repository.findById(bo.getId()).orElse(null);
        if (deviceInfo != null) {
            bo.updateEntity(deviceInfo);
            repository.save(deviceInfo);
        } else {
            log.warn("找不到网关设备, UID: {}", bo.getId());
        }
    }
}
