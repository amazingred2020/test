package com.senlainc.dao;

import com.senlainc.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccountDaoImpl implements AccountDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Account account) {
        entityManager.persist(account);
    }

    @Override
    public Account getAccountByUserId(Long id) {
        return entityManager.createQuery("select a from Account a where a.user = :id", Account.class)
                .setParameter("id", id).getSingleResult();
    }
}
