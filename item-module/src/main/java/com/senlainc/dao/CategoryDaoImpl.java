package com.senlainc.dao;

import com.senlainc.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
	private EntityManager entityManager;

    public Category save(Category category){
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.persist(category);
        t.commit();

        return category;
    }

    public Category findById(Long id){
        EntityTransaction t = entityManager.getTransaction();
    	Category category;
    	t.begin();
    	category = entityManager.find(Category.class, id);
    	t.commit();

        return category;
    }
}
