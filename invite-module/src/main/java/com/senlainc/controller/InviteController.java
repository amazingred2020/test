package com.senlainc.controller;

import com.senlainc.dto.invite.AddGroupInviteRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;
import com.senlainc.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/invite")
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @GetMapping(value = "/friend/{fromId}/{toId}")
    public void addFriendInvite(@PathVariable Long fromId, @PathVariable Long toId){
        inviteService.addFriendInvite(fromId, toId);
    }

    @GetMapping(value = "/friend/{userId}")
    public List<FriendInvite> getFriendInvitesByUserId(@PathVariable Long userId){
        return inviteService.getAllFriendInvite(userId);
    }

    @PostMapping(value = "/group")
    public void addGroupInvite(@RequestBody @Validated AddGroupInviteRequest request){
        inviteService.addGroupInvite(request);
    }

    @GetMapping(value = "/group/{id}")
    public List<GroupInvite> getGroupInvitesByUserId(@PathVariable("id") Long userId){
        return inviteService.getAllGroupInvite(userId);
    }
}
