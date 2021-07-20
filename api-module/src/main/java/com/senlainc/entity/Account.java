package com.senlainc.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Account {

    @Column(nullable = false)
    private Long accountNumber;

    @Column(nullable = false)
    @org.hibernate.annotations.ColumnDefault("0.00")
    @org.hibernate.annotations.Generated(
            org.hibernate.annotations.GenerationTime.INSERT
    )
    private BigDecimal accountPrice;

    public Account(){
    }

    public BigDecimal getAccountPrice() {
        return accountPrice;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void withdrawMoney(BigDecimal price){
        accountPrice = getAccountPrice().subtract(price);
    }

    public void putMoney(BigDecimal price){
        accountPrice = getAccountPrice().add(price);
    }
}
