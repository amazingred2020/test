package com.senlainc.service;

import com.senlainc.entity.User;

public interface UserService {

    User findUserById(Long id);
    User saveUser(User category);
    void deleteUser(Long id);
    void addFriend(Long userId, Long friendId);
    void deleteFriend(Long userId, Long friendId);
}
