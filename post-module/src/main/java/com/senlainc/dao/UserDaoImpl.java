package com.senlainc.dao;

import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public void addFriend(Long userId, Long friendId) {
    }

    @Override
    public void deleteFriend(Long userId, Long friendId) {
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findByCriteries(String name, String surname) {
        return null;
    }
}
