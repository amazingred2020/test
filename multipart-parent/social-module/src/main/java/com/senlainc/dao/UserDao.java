package com.senlainc.dao;

import com.senlainc.entity.User;
import com.senlainc.util.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDao {

	private EntityManager em = EMUtil.getEntityManager();

    public void save(User user){
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
        EMUtil.close();
      }
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
        EMUtil.close();
      }
      return user;
    }
}
