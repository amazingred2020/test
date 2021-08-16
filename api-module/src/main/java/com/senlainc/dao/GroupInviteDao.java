package com.senlainc.dao;

import com.senlainc.entity.GroupInvite;

import java.util.List;
import java.util.Optional;

public interface GroupInviteDao {

    GroupInvite save(GroupInvite groupInvite);
    void remove(Long id);
    GroupInvite findById(Long id);
    List<GroupInvite> findInvitesByUserId(Long userId);
    Optional<GroupInvite> findInviteByUsersId(Long fromId, Long userId);
}
