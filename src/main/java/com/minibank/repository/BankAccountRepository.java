package com.minibank.repository;

import com.minibank.model.BankAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccountDetails, Long> {

    BankAccountDetails findByUserId(Long id);
}
