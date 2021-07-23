package com.senlainc.service;

import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.Invite;

public interface InviteService {

    void save(FriendInvite friendInvite);
    void deleteFriendInvite(Long id);
    void deleteInviteByUserToId(Long userTo);
    FriendInvite changeInviteStatus(FriendInvite friendInvite);
}
