package com.senlainc.service;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;
import com.senlainc.service.UserService;
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

	@Override
	public void deleteUser(Long id) {
		userDao.remove(id);
	}

	@Override
	public void addFriend(Long userId, Long friendId) {
		userDao.addFriend(userId, friendId);
	}

	@Override
	public void deleteFriend(Long userId, Long friendId) {
		userDao.deleteFriend(userId, friendId);
	}

}
