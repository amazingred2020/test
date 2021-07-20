package com.senlainc.dao;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User save(User user){
        entityManager.persist(user);
      
        return user;
    }

    public User findById(Long id){
        User user = entityManager.find(User.class, id);

        return user;
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void addFriend(Long userId, Long friendId) {
        findById(userId).addFriend(findById(friendId));
    }

    @Override
    public void deleteFriend(Long userId, Long friendId) {
        findById(userId).deleteFriend(findById(friendId));
    }
}

