package com.senlainc.dao;

import com.senlainc.entity.Account;

import java.util.Optional;

public interface AccountDao {

    void save(Account account);
    Optional<Account> getAccountByUser(Long id);
}
