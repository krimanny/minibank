package com.minibank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_ACCT")
public class BankAccountDetails implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long accountId;

    private Long userId;

    private int amount = 0;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BankAccountDetails{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}
