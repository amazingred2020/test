package com.senlainc.app.dao;

import com.senlainc.app.entity.User;
import com.senlainc.util.EntityManagerUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDaoImpl implements UserDao {

	private EntityManager em = EntityManagerUtility.getEntityManager();

    public User save(User user){
      try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          em.persist(user);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EntityManagerUtility.close();
      }
      
      return user;
    }

    public User findById(Long id){
    	User user;
    	try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          user = em.find(User.class, id);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EntityManagerUtility.close();
      }
    	
      return user;
    }
}

