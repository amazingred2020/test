package com.senlainc.service;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.UserCriteriaRequest;
import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);
    User saveUser(UserRequest request);
    void addFriend(AddFriendRequest addFriendRequest);
    void deleteFriend(Long userId, Long friendId);
    void changeRole(Long userId, Long roleId);
    List<User> findUsersByCriteria(UserCriteriaRequest request);
}
