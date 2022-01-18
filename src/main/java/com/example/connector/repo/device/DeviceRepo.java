package com.example.connector.repo.device;

import com.example.connector.entity.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<Device, Long> {}
