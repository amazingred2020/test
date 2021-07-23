package com.senlainc.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", nullable = false)
    private Long accountNumber;

    @Column(name = "money", nullable = false)
    private BigDecimal accountMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Account(){
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void withdrawMoney(BigDecimal price){
        accountMoney = getAccountMoney().subtract(price);
    }

    public void putMoney(BigDecimal price){
        accountMoney = getAccountMoney().add(price);
    }
}
