package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;

public interface FriendsInviteDao {

    void save(FriendInvite friendInvite);
    void remove(Long id);
    FriendInvite findById(Long id);
    void deleteByUsersId(Long userFrom, Long userTo);
}
