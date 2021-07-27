package com.senlainc.controller;

import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.NewGroupRequest;
import com.senlainc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping(value = "/new")
    public void newGroup(@RequestBody @Valid NewGroupRequest request, BindingResult result){
        if(!result.hasErrors()){
            groupService.addGroup(request);
        }
    }

    @GetMapping(value = "/{id}")
    public void deleteGroup(@PathVariable("id") Long groupId){
        groupService.deleteGroup(groupId);
    }

    @PostMapping(value = "/change")
    public void changeAdmin(@RequestBody @Valid GroupUserRequest request, BindingResult result){
        if(!result.hasErrors()) groupService.changeAdmin(request.getGroupId(), request.getUserId());
    }

    @PostMapping(value = "/user/a")
    public void addUserToGroup(@RequestBody @Valid GroupUserRequest request, BindingResult result){
        if(!result.hasErrors()) groupService.addUserToGroup(request.getGroupId(), request.getUserId(), request.getUserFromId());
    }

    @GetMapping(value = "/user/d")
    public void removeUserFromGroup(@RequestBody @Valid GroupUserRequest request, BindingResult result){
        if(!result.hasErrors()) groupService.removeUserFromGroup(request.getGroupId(), request.getUserId());
    }
}
