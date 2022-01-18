package com.example.connector.service.chiller;

import com.example.connector.bo.chiller.ChillerDeviceInfoBo;
import com.example.connector.bo.chiller.ChillerRunDataBo;
import com.example.connector.bo.chiller.ChillerRunPowerDataBo;
import com.example.connector.bo.chiller.ChillerRunScheduleDataBo;
import com.example.connector.bo.chiller.ChillerRunStateDataBo;
import com.example.connector.entity.chiller.ChillerDeviceInfo;
import com.example.connector.repo.chiller.ChillerDeviceInfoRepository;
import com.example.connector.repo.chiller.ChillerRunDataRepository;
import com.example.connector.repo.chiller.ChillerRunPowerDataRepository;
import com.example.connector.repo.chiller.ChillerRunScheduleDataRepository;
import com.example.connector.repo.chiller.ChillerRunStateDataRepository;
import com.example.connector.vo.chiller.ChillerDeviceInfoVo;
import com.example.connector.vo.chiller.ChillerRunDataVo;
import com.example.connector.vo.chiller.ChillerRunPowerDataVo;
import com.example.connector.vo.chiller.ChillerRunStateDataVo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChillerServiceImpl implements ChillerService, ChillerServiceBiz {
    @Autowired ChillerDeviceInfoRepository chillerDeviceInfoRepository;
    @Autowired ChillerRunDataRepository chillerRunDataRepository;
    @Autowired ChillerRunPowerDataRepository chillerRunPowerDataRepository;
    @Autowired ChillerRunStateDataRepository chillerRunStateDataRepository;
    @Autowired ChillerRunScheduleDataRepository chillerRunScheduleDataRepository;

    @Override
    public List<ChillerDeviceInfoVo> getAllDeviceInfos() {
        return chillerDeviceInfoRepository.findAll().stream()
                .map(ChillerDeviceInfoVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChillerRunDataVo> getAllRunOtherDatas(Long id) {
        return chillerRunDataRepository.findAll().stream()
                .map(ChillerRunDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChillerRunPowerDataVo> getAllRunPowerDatas(Long id) {
        return chillerRunPowerDataRepository.findAll().stream()
                .map(ChillerRunPowerDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChillerRunStateDataVo> getAllRunStateDatas(Long id) {
        return chillerRunStateDataRepository.findAll().stream()
                .map(ChillerRunStateDataVo::new)
                .collect(Collectors.toList());
    }

    @Override
    public void updateDeviceInfo(ChillerDeviceInfoBo bo) {
        Long id = bo.getId();
        ChillerDeviceInfo deviceInfo = chillerDeviceInfoRepository.findById(id).orElse(null);
        if (deviceInfo == null) {
            log.warn("负控设备不存在, id: {}", id);
            return;
        }
        bo.updateEntity(deviceInfo);
        chillerDeviceInfoRepository.save(deviceInfo);
    }

    @Override
    public void addRunStateData(ChillerRunStateDataBo bo) {
        chillerRunStateDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunScheduleData(ChillerRunScheduleDataBo bo) {
        chillerRunScheduleDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunPowerData(ChillerRunPowerDataBo bo) {
        chillerRunPowerDataRepository.save(bo.getEntity());
    }

    @Override
    public void addRunData(ChillerRunDataBo bo) {
        chillerRunDataRepository.save(bo.getEntity());
    }
}
