package com.senlainc.dao;

import com.senlainc.entity.Category;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CategoryDao {

    private final EntityManager em = Persistence.createEntityManagerFactory("socialdbunit").createEntityManager();

    private EntityManager getEntityManager(){
        return em;
    }

    public void save(Category category){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
    }

    public Category findById(Long id){
        EntityManager em = getEntityManager();
        return em.find(Category.class, id);
    }
}
