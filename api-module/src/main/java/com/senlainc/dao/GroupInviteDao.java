package com.senlainc.dao;

import com.senlainc.entity.GroupInvite;

public interface GroupInviteDao {

    GroupInvite save(GroupInvite groupInvite);
    void remove(Long id);
    GroupInvite findById(Long id);
    void deleteByUserToId(Long userTo);
}
