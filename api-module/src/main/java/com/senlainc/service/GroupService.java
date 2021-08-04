package com.senlainc.service;

import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.NewGroupRequest;
import com.senlainc.entity.Group;

public interface GroupService {

    Group saveGroup(Group group);
    void deleteGroup(Long id);
    void addUserToGroup(GroupUserRequest request);
    void removeUserFromGroup(Long groupId, Long userId);
    void addGroup(NewGroupRequest request);
    void changeAdmin(Long groupId, Long userId);
}
