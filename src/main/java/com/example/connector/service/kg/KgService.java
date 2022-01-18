package com.example.connector.service.kg;

import com.example.connector.vo.kg.KgDeviceInfoVo;
import com.example.connector.vo.kg.KgRunElectricityDataVo;
import com.example.connector.vo.kg.KgRunOtherDataVo;
import com.example.connector.vo.kg.KgRunPowerDataVo;
import com.example.connector.vo.kg.KgRunStateDataVo;
import java.util.List;

public interface KgService {
    List<KgDeviceInfoVo> getAllDeviceInfos();

    /**
     * 根据设备 id 获取所有运行时电力数据
     *
     * @param id 设备的 id
     */
    List<KgRunElectricityDataVo> getAllRunElectricityDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时其他数据
     *
     * @param id 设备的 id
     */
    List<KgRunOtherDataVo> getAllRunOtherDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时能耗数据
     *
     * @param id 设备的 id
     */
    List<KgRunPowerDataVo> getAllRunPowerDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时状态数据
     *
     * @param id 设备的 id
     */
    List<KgRunStateDataVo> getAllRunStateDatas(Long id);
}
