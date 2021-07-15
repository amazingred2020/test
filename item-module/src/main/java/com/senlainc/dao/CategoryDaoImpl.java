package com.senlainc.dao;

import com.senlainc.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
	private EntityManager entityManager;

    public Category save(Category category){
        entityManager.persist(category);

        return category;
    }

    public Category findById(Long id){
    	return entityManager.find(Category.class, id);
    }
}
