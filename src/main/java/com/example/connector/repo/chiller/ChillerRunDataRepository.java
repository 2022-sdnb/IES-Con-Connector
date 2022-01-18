package com.example.connector.repo.chiller;

import com.example.connector.entity.chiller.ChillerRunData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChillerRunDataRepository extends JpaRepository<ChillerRunData, Long> {}
