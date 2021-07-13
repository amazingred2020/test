package com.senlainc.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.senlainc.app.entity.Category;
import com.senlainc.util.EntityManagerUtility;

public class CategoryDaoImpl implements CategoryDao{

	private EntityManager em = EntityManagerUtility.getEntityManager();

    public Category save(Category category){
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
        EntityManagerUtility.close();
      }
      
      return category;
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
        EntityManagerUtility.close();
      }
    	
      return category;
    }
}
