package com.senlainc.dao;

import com.senlainc.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
	
	User save(User user);
	User findById(Long id);
    void remove(Long id);
    void addFriend(Long userId, Long friendId);
	void deleteFriend(Long userId, Long friendId);
	User findByUsername(String username);
	List<User> findByParameters(String name, String surname);

	Optional<List<User>> getUsersByTextSearch(String firstName, String lastName, String city);
}
