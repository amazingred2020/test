package com.senlainc.service;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;

	@Transactional(readOnly = true)
	public User findUserById(Long id) {
		return userDao.findById(id);
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}

}
