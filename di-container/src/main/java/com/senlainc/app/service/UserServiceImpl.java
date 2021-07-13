package com.senlainc.app.service;
import com.senlainc.container.annotation.InjectComponent;
import com.senlainc.container.factory.ComponentFactory;
import com.senlainc.app.dao.UserDao;
import com.senlainc.app.entity.User;

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
