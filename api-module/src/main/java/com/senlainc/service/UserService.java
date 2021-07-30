package com.senlainc.service;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.User;

public interface UserService {

    User findUserById(Long id);
    User saveUser(UserRequest request);
    void deleteUser(Long id);
    void addFriend(AddFriendRequest addFriendRequest);
    void deleteFriend(Long userId, Long friendId);
    void changeRole(Long userId, Long roleId);
}
