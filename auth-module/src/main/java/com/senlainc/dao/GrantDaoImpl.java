package com.senlainc.dao;

import com.senlainc.entity.Grant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GrantDaoImpl implements GrantDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Grant save(Grant grant) {
        if(grant.getId() == null){
            entityManager.persist(grant);
        } else {
            entityManager.merge(grant);
        }

        return grant;
    }

    @Override
    public Grant findById(Long id) {
        return entityManager.find(Grant.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public Grant findGrantByName(String name) {
        return entityManager.createQuery("select g from Grant g where g.name = :name", Grant.class)
                .setParameter("name", name).getSingleResult();
    }
}
