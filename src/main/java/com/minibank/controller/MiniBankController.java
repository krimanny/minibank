package com.minibank.controller;

import com.minibank.dto.RequestDto;
import com.minibank.dto.TransferDto;
import com.minibank.model.Transactions;
import com.minibank.service.MiniBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/minibank")
public class MiniBankController {

    @Autowired
    MiniBankService miniBankService;


    @GetMapping("/totalUsers")
    public int getCountUsers() {
        return miniBankService.countUser();
    }

    @GetMapping("/accountDetails")
    public RequestDto getAccountDetails(@RequestParam Long id) {
        return miniBankService.getAccountDetails(id);
    }

    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions(@RequestParam Long id) {
        return miniBankService.getAllTransactions(id);
    }

    @PostMapping("/deposit")
    public String depositAmount(@RequestBody RequestDto requestDto){
        return  miniBankService.deposit(requestDto.getAmount(), requestDto.getId());
    }

    @PostMapping("/withdraw")
    public String withDrawAmount(@RequestBody RequestDto requestDto){
        return  miniBankService.withdraw(requestDto.getAmount(), requestDto.getId());
    }

    @PostMapping("/transfer")
    public String withDrawAmount(@RequestBody TransferDto transferDto){
        return  miniBankService.transfer(transferDto.getAmount(),
                transferDto.getId(), transferDto.getTransferId());
    }
}
