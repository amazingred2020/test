package com.senlainc.controller;

import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.NewGroupRequest;
import com.senlainc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping(value = "/new")
    public void newGroup(@RequestBody @Validated NewGroupRequest request){
        groupService.addGroup(request);
    }

    @GetMapping(value = "/{id}")
    public void deleteGroup(@PathVariable("id") Long groupId){
        groupService.deleteGroup(groupId);
    }

    @PostMapping(value = "/change")
    public void changeAdmin(@RequestBody @Validated GroupUserRequest request){
        groupService.changeAdmin(request.getGroupId(), request.getUserId());
    }

    @PostMapping(value = "/user/add")
    public void addUserToGroup(@RequestBody @Validated GroupUserRequest request){
        groupService.addUserToGroup(request);
    }

    @GetMapping(value = "/user/delete")
    public void removeUserFromGroup(@RequestBody @Validated GroupUserRequest request){
        groupService.removeUserFromGroup(request.getGroupId(), request.getUserId());
    }
}
