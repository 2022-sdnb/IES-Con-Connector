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
        // map调用Vo的构造方法从repo得到的entity中构建返回给上层的Vo对象
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
        // 需要确保数据库中相应数据条目存在
        if (deviceInfo == null) {
            log.warn("负控设备不存在, id: {}", id);
            return;
        }
        bo.updateEntity(deviceInfo);
        chargerDeviceInfoRepository.save(deviceInfo);
    }

    @Override
    public void addRunOtherData(ChargerRunOtherDataBo bo) {
        // 通过Bo来承载相应的业务数据，下面也是一样的逻辑
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
