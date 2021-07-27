package com.senlainc.dao;

import com.senlainc.entity.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GroupDaoImpl implements GroupDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Group save(Group group) {
        if(group.getId() == null){
            entityManager.persist(group);
        } else {
            entityManager.merge(group);
        }

        return group;
    }

    @Override
    public Group findById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void changeGroupAdmin(Long groupId, Long userId) {

    }

    @Override
    public void addUserToGroup(Long groupId, Long userId) {

    }

    @Override
    public void removeUserFromGroup(Long groupId, Long userId) {

    }
}
