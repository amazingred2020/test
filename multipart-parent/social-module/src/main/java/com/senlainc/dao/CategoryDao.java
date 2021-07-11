package com.senlainc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.senlainc.entity.Category;
import com.senlainc.util.EMUtil;

public class CategoryDao {

	private EntityManager em = EMUtil.getEntityManager();

    public void save(Category category){
      try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          em.persist(category);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EMUtil.close();
      }
    }

    public Category findById(Long id){
    	Category category;
    	try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          category = em.find(Category.class, id);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EMUtil.close();
      }
      return category;
    }
}
