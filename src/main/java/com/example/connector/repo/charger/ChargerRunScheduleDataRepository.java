package com.example.connector.repo.charger;

import com.example.connector.entity.charger.ChargerRunScheduleData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargerRunScheduleDataRepository
        extends JpaRepository<ChargerRunScheduleData, Long> {}
