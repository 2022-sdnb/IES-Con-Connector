package com.example.connector.repo.cmd;

import com.example.connector.entity.cmd.OwnerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerAccountRepository extends JpaRepository<OwnerAccount, Long> {}
