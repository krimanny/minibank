package com.minibank.service.impl;

import com.minibank.dto.RequestDto;
import com.minibank.model.BankAccountDetails;
import com.minibank.model.Transactions;
import com.minibank.repository.BankAccountRepository;
import com.minibank.repository.TransactionRepository;
import com.minibank.repository.UserRepository;
import com.minibank.service.MiniBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniBankServiceImpl implements MiniBankService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public int countUser() {
        return userRepository.countUser();
    }

    @Override
    public List<Transactions> getAllTransactions(Long id) {
        return transactionRepository.findAllByUserId(id);
    }

    @Override
    public String withdraw(int amount, Long id) {
        BankAccountDetails acct = bankAccountRepository.findByUserId(id);
        if(acct != null) {
            if (acct.getAmount() <= 0 || acct.getAmount() < amount) {
                return "Failed: Amount is insufficient";
            }

            acct.setAmount(acct.getAmount() - amount);
            bankAccountRepository.saveAndFlush(acct);
            Transactions transactions = new Transactions();
            transactions.setActivity("WITHDRAW");
            transactions.setUserId(id);
            transactionRepository.saveAndFlush(transactions);
            return "Success";
        }
        return "Failed";
    }

    @Override
    public String deposit(int amount, Long id) {
        BankAccountDetails acct = bankAccountRepository.findByUserId(id);
        if(acct != null) {
            acct.setAmount(acct.getAmount() + amount);
            bankAccountRepository.saveAndFlush(acct);
            Transactions transactions = new Transactions();
            transactions.setActivity("DEPOSIT");
            transactions.setUserId(id);
            transactionRepository.saveAndFlush(transactions);
            return "Success";
        }
        return "Failed";
    }

    @Override
    public String transfer(int amount, Long id, Long transferId) {
        BankAccountDetails acct = bankAccountRepository.findByUserId(id);
        if(acct != null) {
            if (acct.getAmount() <= 0 || acct.getAmount() < amount) {
                return "Failed: Amount is insufficient";
            }

           BankAccountDetails transferAcct = bankAccountRepository.findByUserId(transferId);
           if(transferAcct != null){
               transferAcct.setAmount(transferAcct.getAmount() + amount);
               acct.setAmount(acct.getAmount() - amount);
               bankAccountRepository.saveAndFlush(transferAcct);
               bankAccountRepository.saveAndFlush(acct);
               Transactions transactions = new Transactions();
               transactions.setActivity("TRANSFER");
               transactions.setUserId(id);
               transactionRepository.saveAndFlush(transactions);
               return "SUCCESS";
           }
        }
        return "Failed";
    }

    @Override
    public RequestDto getAccountDetails(Long id) {
        BankAccountDetails acct = bankAccountRepository.findByUserId(id);
        RequestDto requestDto = new RequestDto();
        if(acct != null){
            requestDto.setAmount(acct.getAmount());
            requestDto.setId(acct.getAccountId());
            return requestDto;
        }
        return requestDto;
    }
}
