package com.senlainc.dao;

import com.senlainc.entity.Group;
import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Group save(Group group){
        if(group.getId() == null){
            entityManager.persist(group);
        } else {
            entityManager.merge(group);
        }

        return group;
    }

    public void changeGroupAdmin(Long groupId, Long userId){
        findById(groupId).setAdmin(entityManager.find(User.class, userId));
    }

    @Override
    public Group findById(Long id) {
        return entityManager.find(Group.class, id);
    }

    public void addUserToGroup(Long groupId, Long userId){
        entityManager.find(Group.class, groupId).addUserToGroup(entityManager.find(User.class, userId));
    }

    public void removeUserFromGroup(Long groupId, Long userId){
        entityManager.find(Group.class, groupId).removeUserFromGroup(entityManager.find(User.class, userId));
    }
}