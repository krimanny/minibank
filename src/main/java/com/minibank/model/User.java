package com.minibank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private BankAccountDetails accountDetails;

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", accountDetails=" + accountDetails +
                '}';
    }
}