package com.example.connector.service.chiller;

import com.example.connector.vo.chiller.ChillerDeviceInfoVo;
import com.example.connector.vo.chiller.ChillerRunDataVo;
import com.example.connector.vo.chiller.ChillerRunPowerDataVo;
import com.example.connector.vo.chiller.ChillerRunStateDataVo;
import java.util.List;

public interface ChillerService {
    List<ChillerDeviceInfoVo> getAllDeviceInfos();

    /**
     * 根据设备 id 获取所有运行时其他数据
     *
     * @param id 设备的 id
     */
    List<ChillerRunDataVo> getAllRunOtherDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时能耗数据
     *
     * @param id 设备的 id
     */
    List<ChillerRunPowerDataVo> getAllRunPowerDatas(Long id);

    /**
     * 根据设备 id 获取所有运行时状态数据
     *
     * @param id 设备的 id
     */
    List<ChillerRunStateDataVo> getAllRunStateDatas(Long id);
}
