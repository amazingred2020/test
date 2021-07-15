package com.senlainc.dao;

import com.senlainc.entity.User;
import com.senlainc.dao.UserDao;
import com.senlainc.util.EntityManagerUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDaoImpl implements UserDao {

	private EntityManager entityManager = EntityManagerUtility.getEntityManager();

    public User save(User user){
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            entityManager.persist(user);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
        }
      
        return user;
    }

    public User findById(Long id){
        User user;
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            user = entityManager.find(User.class, id);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
        }

        return user;
    }
}

