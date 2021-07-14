package com.senlainc.dao;

import com.senlainc.entity.Category;
import com.senlainc.util.EntityManagerUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CategoryDaoImpl implements CategoryDao {

	private EntityManager entityManager;

    public Category save(Category category){
        entityManager = EntityManagerUtility.getEntityManager();
        try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                entityManager.persist(category);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }

        return category;
    }

    public Category findById(Long id){
        entityManager = EntityManagerUtility.getEntityManager();
    	Category category;
    	try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                category = entityManager.find(Category.class, id);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }
    	
        return category;
    }
}
