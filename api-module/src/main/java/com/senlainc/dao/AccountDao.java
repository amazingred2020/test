package com.senlainc.dao;

import com.senlainc.entity.Account;

public interface AccountDao {

    void save(Account account);
    Account getAccountByUserId(Long id);
}
