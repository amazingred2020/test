package com.senlainc.controller;

import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.NewGroupRequest;
import com.senlainc.routes.GroupRoutes;
import com.senlainc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping(GroupRoutes.GROUP)
    public void newGroup(@RequestBody @Validated NewGroupRequest request){
        groupService.addGroup(request);
    }

    @DeleteMapping(GroupRoutes.DELETE_GROUP)
    public void deleteGroup(@PathVariable("id") Long groupId){
        groupService.deleteGroup(groupId);
    }

    @PutMapping(GroupRoutes.CHANGE_ADMIN)
    public void changeAdmin(@RequestBody @Validated GroupUserRequest request){
        groupService.changeAdmin(request.getGroupId(), request.getUserId());
    }

    @PostMapping(GroupRoutes.ADD_USER_TO_GROUP)
    public void addUserToGroup(@RequestBody @Validated GroupUserRequest request){
        groupService.addUserToGroup(request);
    }

    @PostMapping(GroupRoutes.DELETE_USER_FROM_GROUP)
    public void removeUserFromGroup(@RequestBody @Validated GroupUserRequest request){
        groupService.removeUserFromGroup(request.getGroupId(), request.getUserId());
    }
}
