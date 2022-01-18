package com.example.connector.repo.charger;

import com.example.connector.entity.charger.ChargerRunElectricityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargerRunElectricityDataRepository
        extends JpaRepository<ChargerRunElectricityData, Long> {}
