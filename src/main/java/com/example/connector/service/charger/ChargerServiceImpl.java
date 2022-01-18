package com.example.connector.service.charger;

import com.example.connector.bo.charger.*;
import com.example.connector.entity.charger.ChargerDeviceInfo;
import com.example.connector.repo.charger.*;
import com.example.connector.vo.charger.*;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lmt
 * @date 2021/10/10 15:38
 */
@Slf4j
@Service
public class ChargerServiceImpl implements ChargerService, ChargerServiceBiz {
    @Autowired ChargerDeviceInfoRepository chargerDeviceInfoRepository;
    @Autowired ChargerRunEnergyDataRepository chargerRunEnergyDataRepository;
    @Autowired ChargerRunElectricityDataRepository chargerRunElectricityDataRepository;
    @Autowired ChargerRunOtherDataRepository chargerRunOtherDataRepository;
    @Autowired ChargerRunPowerDataRepository chargerRunPowerDataRepository;
    @Autowired ChargerRunStateDataRepository chargerRunStateDataRepository;

    @Override
    public List<ChargerDeviceInfoVo> getAllDeviceInfos() {
        return chargerDeviceInfoRepository.findAll().stream()
                .map(ChargerDeviceInfoVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargerRunElectricityDataVo> getAllRunElectricityDatas(Long id) {
        return chargerRunElectricityDataRepository.findAll().stream()
                .map(ChargerRunElectricityDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargerRunOtherDataVo> getAllRunOtherDatas(Long id) {
        return chargerRunOtherDataRepository.findAll().stream()
                .map(ChargerRunOtherDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargerRunPowerDataVo> getAllRunPowerDatas(Long id) {
        return chargerRunPowerDataRepository.findAll().stream()
                .map(ChargerRunPowerDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargerRunStateDataVo> getAllRunStateDatas(Long id) {
        return chargerRunStateDataRepository.findAll().stream()
                .map(ChargerRunStateDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public void updateDeviceInfo(ChargerDeviceInfoBo bo) {
        Long id = bo.getId();
        ChargerDeviceInfo deviceInfo = chargerDeviceInfoRepository.findById(id).orElse(null);
        if (deviceInfo == null) {
            log.warn("负控设备不存在, id: {}", id);
            return;
        }
        bo.updateEntity(deviceInfo);
        chargerDeviceInfoRepository.save(deviceInfo);
    }

    @Override
    public void addRunOtherData(ChargerRunOtherDataBo bo) {
        chargerRunOtherDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunPowerData(ChargerRunPowerDataBo bo) {
        chargerRunPowerDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunStateData(ChargerRunStateDataBo bo) {
        chargerRunStateDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunEnergyData(ChargerRunEnergyDataBo bo) {
        chargerRunEnergyDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunElectricityData(ChargerRunElectricityDataBo bo) {
        chargerRunElectricityDataRepository.save(bo.getEntity());
    }
}
