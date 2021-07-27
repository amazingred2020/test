package com.senlainc.controller;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.DeleteFriendRequest;
import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.User;
import com.senlainc.service.RoleService;
import com.senlainc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
    private RoleService roleService;

    @PostMapping(value="/new")
    public User addUser(@RequestBody @Valid UserRequest request, @RequestParam(required = false) Long roleId){
    	User newUser = request.convertToUserEntity();
        if(roleId != null){
            newUser.setRole(roleService.findRoleById(roleId));
        }
        userService.saveUser(newUser);

    	return newUser;
    }

    @GetMapping(value = "/find/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping(value = "/role")
    private void changeUserRole(@RequestParam Long userId, @RequestParam Long roleId){
        userService.findUserById(userId).setRole(roleService.findRoleById(roleId));
    }

    @PostMapping(value = "/friend/add")
    public void addFriend(@RequestBody AddFriendRequest request){
        userService.addFriend(request);
    }


    @PostMapping(value = "/friend/delete")
    public void deleteFriend(@RequestBody DeleteFriendRequest deleteEvent){
        userService.deleteFriend(deleteEvent.getUserFrom(), deleteEvent.getUserTo());
    }
}