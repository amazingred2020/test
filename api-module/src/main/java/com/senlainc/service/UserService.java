package com.senlainc.service;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.GetUserRequest;
import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.dto.user.UserTextSearchRequest;
import com.senlainc.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);
    User saveUser(SaveUserRequest request);
    void addFriend(AddFriendRequest addFriendRequest);
    void deleteFriend(Long userId, Long friendId);
    void changeRole(Long userId, Long roleId);
    List<User> findUsersByParameters(GetUserRequest request);

    List<User> getUsersByTextSearch(UserTextSearchRequest request);
    List<User> getPaginatedUserList(int page, int size);
}
