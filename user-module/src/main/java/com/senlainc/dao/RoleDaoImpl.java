package com.senlainc.dao;

import com.senlainc.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role save(Role role) {
        if(role.getId() == null){
            entityManager.persist(role);
        } else {
            entityManager.merge(role);
        }

        return role;
    }

    @Override
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
