package com.senlainc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", nullable = false)
    private Long accountNumber;

    @Column(name = "money")
    private BigDecimal accountMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Account(){
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void withdrawMoney(BigDecimal price){
        accountMoney = getAccountMoney().subtract(price);
    }

    public void putMoney(BigDecimal price){
        accountMoney = getAccountMoney().add(price);
    }
}
