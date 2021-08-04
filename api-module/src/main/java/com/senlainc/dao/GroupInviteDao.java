package com.senlainc.dao;

import com.senlainc.entity.GroupInvite;

import java.util.List;

public interface GroupInviteDao {

    GroupInvite save(GroupInvite groupInvite);
    void remove(Long id);
    GroupInvite findById(Long id);
    List<GroupInvite> findInvitesByUserId(Long userId);
    GroupInvite findInviteByUsersId(Long fromId, Long userId);
}
