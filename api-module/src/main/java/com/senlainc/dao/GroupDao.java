package com.senlainc.dao;

import com.senlainc.entity.Group;

public interface GroupDao {

    Group save(Group group);
    Group findById(Long id);
    void changeGroupAdmin(Long groupId, Long userId);
    void addUserToGroup(Long groupId, Long userId);
    void removeUserFromGroup(Long groupId, Long userId);
}
