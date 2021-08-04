package com.senlainc.dao;

import com.senlainc.entity.Account;
import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements AccountDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Account account) {
        entityManager.persist(account);
    }

    @Override
    public Optional<Account> getAccountByUser(Long id) {
         return entityManager.createQuery("select a from Account a where a.user.id = :id", Account.class)
                 .setParameter("id", id).setMaxResults(1).getResultList().stream().findFirst();
    }
}
