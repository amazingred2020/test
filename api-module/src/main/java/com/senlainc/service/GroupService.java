package com.senlainc.service;

import com.senlainc.entity.Group;

public interface GroupService {

    Group saveGroup(Group group);
    void addUserToGroup(Long groupId, Long userId);
    void removeUserFromGroup(Long groupId, Long userId);
}
