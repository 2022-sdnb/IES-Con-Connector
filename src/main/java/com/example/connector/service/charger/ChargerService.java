package com.example.connector.service.charger;

import com.example.connector.vo.charger.*;
import java.util.List;

/**
 * @author Lmt
 * @date 2021/10/10 15:37
 */
public interface ChargerService {
    List<ChargerDeviceInfoVo> getAllDeviceInfos();

    /**
     * 根据设备 id 获取所有运行时电力数据
     *
     * @param id 设备的 id
     */
    List<ChargerRunElectricityDataVo> getAllRunElectricityDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时其他数据
     *
     * @param id 设备的 id
     */
    List<ChargerRunOtherDataVo> getAllRunOtherDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时能耗数据
     *
     * @param id 设备的 id
     */
    List<ChargerRunPowerDataVo> getAllRunPowerDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时状态数据
     *
     * @param id 设备的 id
     */
    List<ChargerRunStateDataVo> getAllRunStateDatas(Long id);
}
