package com.senlainc.dao;

import com.senlainc.entity.User;

public interface UserDao {
	
	User save(User user);
	User findById(Long id);
}
