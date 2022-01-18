package com.example.connector.repo.chiller;

import com.example.connector.entity.chiller.ChillerRunScheduleData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChillerRunScheduleDataRepository
        extends JpaRepository<ChillerRunScheduleData, Long> {}
