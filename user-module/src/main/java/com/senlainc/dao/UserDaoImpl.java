package com.senlainc.dao;

import com.senlainc.entity.User;
import com.senlainc.dao.UserDao;
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
}

