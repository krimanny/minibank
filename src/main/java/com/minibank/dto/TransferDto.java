package com.minibank.dto;

import java.io.Serializable;

public class TransferDto implements Serializable {

    private int amount;
    private Long id;
    private Long transferId;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }
}
