package com.senlainc.dao;

import com.senlainc.entity.Category;
import com.senlainc.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDao {

    private final EntityManager em = Persistence.createEntityManagerFactory("socialdbunit").createEntityManager();

    private EntityManager getEntityManager(){
        return em;
    }

    public void save(User user){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User findById(Long id){
        EntityManager em = getEntityManager();
        return em.find(User.class, id);
    }
}
