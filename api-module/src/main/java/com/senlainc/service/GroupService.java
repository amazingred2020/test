package com.senlainc.service;

import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.User;

import java.util.List;

public interface GroupService {

    void deleteGroup(Long id);
    void addUserToGroup(GroupUserRequest request);
    void removeUserFromGroup(Long groupId, Long userId);
    void addGroup(SaveGroupRequest request);
    void changeAdmin(Long groupId, Long userId);
    List<User> getGroupSubscribers(long id);
}
