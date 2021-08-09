package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;

import java.util.List;

public interface FriendsInviteDao {

    void save(FriendInvite friendInvite);
    void remove(Long id);
    FriendInvite findById(Long id);
    List<FriendInvite> findInvitesByUserId(Long userId);
    FriendInvite findInvitesByUsersId(Long userFrom, Long userTo);
}
