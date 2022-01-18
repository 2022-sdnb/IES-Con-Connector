package com.example.connector.service.gw;

import com.example.connector.vo.gw.GwDeviceInfoVo;
import java.util.List;

public interface GwService {
    List<GwDeviceInfoVo> getAllDeviceInfos();
}
