package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;

import java.util.List;
import java.util.Optional;

public interface FriendsInviteDao {

    void save(FriendInvite friendInvite);
    void remove(Long id);
    FriendInvite findById(Long id);
    List<FriendInvite> findInvitesByUserId(Long userId);
    Optional<FriendInvite> findInvitesByUsersId(Long userFrom, Long userTo);
}
