package com.senlainc.app.dao;

import com.senlainc.app.entity.User;

public interface UserDao {
	
	User save(User user);
	User findById(Long id);
}
