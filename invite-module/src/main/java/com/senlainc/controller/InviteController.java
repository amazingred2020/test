package com.senlainc.controller;

import com.senlainc.dto.invite.SaveGroupInviteRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;
import com.senlainc.routes.InviteRoutes;
import com.senlainc.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @GetMapping(InviteRoutes.FRIEND_INVITE)
    public void addFriendInvite(@PathVariable Long fromId, @PathVariable Long toId){
        inviteService.addFriendInvite(fromId, toId);
    }

    @GetMapping(InviteRoutes.FRIEND_INVITES)
    public List<FriendInvite> getFriendInvitesByUserId(@PathVariable Long userId){
        return inviteService.getAllFriendInvite(userId);
    }

    @PostMapping(InviteRoutes.GROUP_INVITE)
    public void addGroupInvite(@RequestBody @Validated SaveGroupInviteRequest request){
        inviteService.addGroupInvite(request);
    }

    @GetMapping(InviteRoutes.GROUP_INVITIES)
    public List<GroupInvite> getGroupInvitesByUserId(@PathVariable("id") Long userId){
        return inviteService.getAllGroupInvite(userId);
    }
}
