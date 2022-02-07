package com.example.connector.repo.charger;

import com.example.connector.entity.charger.ChargerDeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

// 直接继承自Jpa提供的自实现接口
public interface ChargerDeviceInfoRepository extends JpaRepository<ChargerDeviceInfo, Long> {}
