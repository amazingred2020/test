package com.senlainc.service.user;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;

public class UserServiceImpl implements UserService {

    private UserDao ud;

    public UserServiceImpl(){
        ud = new UserDao();
    }

	public User findUserById(Long id) {
		return ud.findById(id);
	}

	public void saveUser(User user) {
		ud.save(user);
	}

}
