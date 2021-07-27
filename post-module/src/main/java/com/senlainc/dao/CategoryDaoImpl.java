package com.senlainc.dao;

import com.senlainc.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryDaoImpl implements  CategoryDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category save(Category category) {
        if(category.getId() == null){
            entityManager.persist(category);
        } else {
            entityManager.merge(category);
        }

        return category;
    }

    @Override
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }
}
