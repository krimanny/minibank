package com.minibank.dto;

import java.io.Serializable;

public class RequestDto implements Serializable {

    private int amount;
    private Long id;

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
}
