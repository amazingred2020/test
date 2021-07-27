package com.senlainc.dao;

import com.senlainc.entity.GroupInvite;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GroupInviteDaoImpl implements GroupInviteDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public GroupInvite save(GroupInvite groupInvite) {
        entityManager.persist(groupInvite);
        return groupInvite;
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public GroupInvite findById(Long id) {
        return entityManager.find(GroupInvite.class, id);
    }

    @Override
    public void deleteByUserToId(Long userTo) {

    }
}
