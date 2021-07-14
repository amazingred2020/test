package com.senlainc.service;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;
import com.senlainc.annotation.InjectComponent;
import com.senlainc.factory.ComponentFactory;

public class UserServiceImpl implements UserService {

	@InjectComponent
    private UserDao userDao;

    public UserServiceImpl(){
		this.userDao = ComponentFactory.getInstance().getComponent(UserDao.class);
    }

	public User findUserById(Long id) {
		return userDao.findById(id);
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}

}
