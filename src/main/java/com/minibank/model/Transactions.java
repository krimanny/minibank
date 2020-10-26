package com.minibank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_TRANSACTIONS")
public class Transactions implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long transactionId;
    private String activity;

    private Long userId;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", activity='" + activity + '\'' +
                ", userId=" + userId +
                '}';
    }
}
