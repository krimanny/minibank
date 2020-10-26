package com.minibank.service;

import com.minibank.dto.RequestDto;
import com.minibank.model.Transactions;

import java.util.List;

public interface MiniBankService {

    public int countUser();

    public List<Transactions> getAllTransactions(Long id);

    public String withdraw(int amount, Long id);

    public String deposit(int amount, Long id);

    public String transfer(int amount, Long id, Long transferId);

    public RequestDto getAccountDetails(Long id);

}
