package com.senlainc.dao;

import com.senlainc.entity.User;
import com.senlainc.dao.UserDao;
import com.senlainc.util.EntityManagerUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;

    public User save(User user){
        entityManager = EntityManagerUtility.getEntityManager();
        try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                entityManager.persist(user);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }
      
        return user;
    }

    public User findById(Long id){
        entityManager = EntityManagerUtility.getEntityManager();
        User user;
    	try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                user = entityManager.find(User.class, id);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }
    	
        return user;
    }
}

