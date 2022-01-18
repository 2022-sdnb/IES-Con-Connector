package com.example.connector.repo.charger;

import com.example.connector.entity.charger.ChargerDeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargerDeviceInfoRepository extends JpaRepository<ChargerDeviceInfo, Long> {}
