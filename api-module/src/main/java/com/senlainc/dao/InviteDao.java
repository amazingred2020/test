package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;

public interface InviteDao {

    void saveFriendsInvite(FriendInvite friendInvite);
    void deleteFriendInvite(Long id);
    FriendInvite findFriendInviteById(Long id);
    void deleteInviteByUserToId(Long userTo);
}
