package com.senlainc.controller;

import com.senlainc.entity.Group;
import com.senlainc.service.GroupService;
import com.senlainc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/new")
    public void addGroup(@RequestBody Group group, @RequestParam Long userId){
        group.setAdmin(userService.findUserById(userId));
        groupService.saveGroup(group);
    }

    @GetMapping(value = "/add/user")
    public void addUserToGroup(@RequestParam Long groupId, @RequestParam Long userId){
        groupService.addUserToGroup(groupId, userId);
    }
    @GetMapping(value = "/del/user")
    public void deleteUserFromGroup(@RequestParam Long groupId, @RequestParam Long userId){
        groupService.removeUserFromGroup(groupId, userId);
    }
}
