package com.example.connector.repo.chiller;

import com.example.connector.entity.chiller.ChillerRunStateData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChillerRunStateDataRepository extends JpaRepository<ChillerRunStateData, Long> {}
