package com.senlainc.service;

import com.senlainc.dto.invite.AddGroupInviteRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;

import java.util.List;

public interface InviteService {
    void addFriendInvite(Long fromId, Long toId);
    List<FriendInvite> getAllFriendInvite(Long userId);
    void addGroupInvite(AddGroupInviteRequest request);
    List<GroupInvite> getAllGroupInvite(Long userId);
}
