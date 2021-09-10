package com.senlainc.controller;

import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.User;
import com.senlainc.routes.GroupRoutes;
import com.senlainc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping(GroupRoutes.GROUP)
    public void newGroup(@RequestBody @Validated SaveGroupRequest request){
        groupService.addGroup(request);
    }

    @DeleteMapping(GroupRoutes.GROUP_BY_ID)
    public void deleteGroup(@PathVariable("id") Long groupId){
        groupService.deleteGroup(groupId);
    }

    @PutMapping(GroupRoutes.GROUP)
    public void changeAdmin(@RequestBody @Validated GroupUserRequest request){
        groupService.changeAdmin(request.getGroupId(), request.getUserId());
    }

    @PostMapping(GroupRoutes.USER_IN)
    public void addUserToGroup(@RequestBody @Validated GroupUserRequest request){
        groupService.addUserToGroup(request);
    }

    @PostMapping(GroupRoutes.USER_OUT)
    public void removeUserFromGroup(@RequestBody @Validated GroupUserRequest request){
        groupService.removeUserFromGroup(request.getGroupId(), request.getUserId());
    }

    @GetMapping(GroupRoutes.SUBSCRIBERS)
    public List<User> getGroupSubscribers(@PathVariable long id){
        return groupService.getGroupSubscribers(id);
    }
}
