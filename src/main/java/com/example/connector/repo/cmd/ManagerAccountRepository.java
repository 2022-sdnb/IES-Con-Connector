package com.example.connector.repo.cmd;

import com.example.connector.entity.cmd.ManagerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerAccountRepository extends JpaRepository<ManagerAccount, Long> {}
