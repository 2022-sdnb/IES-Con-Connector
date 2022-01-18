package com.example.connector.repo.chiller;

import com.example.connector.entity.chiller.ChillerDeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChillerDeviceInfoRepository extends JpaRepository<ChillerDeviceInfo, Long> {}
