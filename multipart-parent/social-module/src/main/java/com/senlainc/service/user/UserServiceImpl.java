package com.senlainc.service.user;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserServiceImpl implements UserService {

    private UserDao ud;

    public UserServiceImpl(){
        ud = new UserDao();
    }

    @Override
    public User findUserById(Long id) {
        return ud.findById(id);
    }

    @Override
    public void saveUser(User user) {
        ud.save(user);
    }
}
