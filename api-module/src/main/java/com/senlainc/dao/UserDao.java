package com.senlainc.dao;

import com.senlainc.entity.User;

public interface UserDao {
	
	User save(User user);
	User findById(Long id);
    void remove(Long id);
    void addFriend(Long userId, Long friendId);
	void deleteFriend(Long userId, Long friendId);
}
