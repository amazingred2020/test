package com.senlainc.dao;

import com.senlainc.entity.Group;
import com.senlainc.entity.User;
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

    private User findUser(Long userId){
        return entityManager.find(User.class, userId);
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
    public Group findByName(String name) {
        return entityManager.createQuery("select g from Group g where g.name = :name", Group.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public void changeGroupAdmin(Long groupId, Long userId) {
        findById(groupId).setUser(findUser(userId));
    }

    @Override
    public void addUserToGroup(Long groupId, Long userId) {
        findById(groupId).addUserToGroup(findUser(userId));
    }

    @Override
    public void removeUserFromGroup(Long groupId, Long userId) {
        findById(groupId).removeUserFromGroup(findUser(userId));
    }
}
