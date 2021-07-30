package com.senlainc.dao;

import com.senlainc.entity.User;

import java.util.List;

public interface UserDao {
	
	User save(User user);
	User findById(Long id);
    void remove(Long id);
    void addFriend(Long userId, Long friendId);
	void deleteFriend(Long userId, Long friendId);
	User findByUsername(String username);
	List<User> findByCriteries(String name, String surname);
}
