package com.example.connector.service.kg;

import com.example.connector.bo.kg.KgDeviceInfoBo;
import com.example.connector.bo.kg.KgRunElectricityDataBo;
import com.example.connector.bo.kg.KgRunOtherDataBo;
import com.example.connector.bo.kg.KgRunPowerDataBo;
import com.example.connector.bo.kg.KgRunStateDataBo;
import com.example.connector.entity.kg.KgDeviceInfo;
import com.example.connector.repo.kg.KgDeviceInfoRepository;
import com.example.connector.repo.kg.KgRunElectricityDataRepository;
import com.example.connector.repo.kg.KgRunOtherDataRepository;
import com.example.connector.repo.kg.KgRunPowerDataRepository;
import com.example.connector.repo.kg.KgRunStateDataRepository;
import com.example.connector.vo.kg.KgDeviceInfoVo;
import com.example.connector.vo.kg.KgRunElectricityDataVo;
import com.example.connector.vo.kg.KgRunOtherDataVo;
import com.example.connector.vo.kg.KgRunPowerDataVo;
import com.example.connector.vo.kg.KgRunStateDataVo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KgServiceImpl implements KgService, KgServiceBiz {

    @Autowired KgDeviceInfoRepository kgDeviceInfoRepository;
    @Autowired KgRunElectricityDataRepository kgRunElectricityDataRepository;
    @Autowired KgRunOtherDataRepository kgRunOtherDataRepository;
    @Autowired KgRunPowerDataRepository kgRunPowerDataRepository;
    @Autowired KgRunStateDataRepository kgRunStateDataRepository;

    @Override
    public List<KgDeviceInfoVo> getAllDeviceInfos() {
        return kgDeviceInfoRepository.findAll().stream()
                .map(KgDeviceInfoVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<KgRunElectricityDataVo> getAllRunElectricityDatas(Long id) {
        return kgRunElectricityDataRepository.findAll().stream()
                .map(KgRunElectricityDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<KgRunOtherDataVo> getAllRunOtherDatas(Long id) {
        return kgRunOtherDataRepository.findAll().stream()
                .map(KgRunOtherDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<KgRunPowerDataVo> getAllRunPowerDatas(Long id) {
        return kgRunPowerDataRepository.findAll().stream()
                .map(KgRunPowerDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<KgRunStateDataVo> getAllRunStateDatas(Long id) {
        return kgRunStateDataRepository.findAll().stream()
                .map(KgRunStateDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public void updateDeviceInfo(KgDeviceInfoBo bo) {
        Long id = bo.getId();
        KgDeviceInfo deviceInfo = kgDeviceInfoRepository.findById(id).orElse(null);
        if (deviceInfo == null) {
            log.info("负控设备不存在, id: {}", id);
            deviceInfo = new KgDeviceInfo(id);
        }
        bo.updateEntity(deviceInfo);
        kgDeviceInfoRepository.save(deviceInfo);
    }

    @Override
    public void addRunElectricityData(KgRunElectricityDataBo bo) {
        kgRunElectricityDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunOtherData(KgRunOtherDataBo bo) {
        kgRunOtherDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunPowerData(KgRunPowerDataBo bo) {
        kgRunPowerDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunStateData(KgRunStateDataBo bo) {
        kgRunStateDataRepository.save(bo.getEntity());
    }
}
