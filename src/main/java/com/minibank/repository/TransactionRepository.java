package com.minibank.repository;

import com.minibank.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    List<Transactions> findAllByUserId(Long userId);
}
