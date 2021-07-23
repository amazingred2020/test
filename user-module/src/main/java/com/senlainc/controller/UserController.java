package com.senlainc.controller;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.DeleteFriendRequest;
import com.senlainc.dto.user.UserDTO;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.Status;
import com.senlainc.entity.User;
import com.senlainc.service.InviteService;
import com.senlainc.service.RoleService;
import com.senlainc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
    private RoleService roleService;

	@Autowired
    private InviteService inviteService;

    @PostMapping(value="/new")
    public User addUser(@RequestBody UserDTO dto, @RequestParam(required = false) Long roleId){
    	User newUser = dto.convertToUserEntity();
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
    public void addFriend(@RequestBody AddFriendRequest requestAddFriend){
        FriendInvite friendInvite = new FriendInvite(userService.findUserById(requestAddFriend.getUserFrom()),
                userService.findUserById(requestAddFriend.getUserTo()),
                requestAddFriend.getStatus());
        inviteService.save(friendInvite);
        friendInvite = inviteService.changeInviteStatus(friendInvite);
        if(friendInvite.getStatus() == Status.CONFIRM){
            userService.addFriend(requestAddFriend.getUserFrom(), requestAddFriend.getUserTo());
            inviteService.deleteFriendInvite(requestAddFriend.getUserTo());
        }
    }


    @PostMapping(value = "/friend/delete")
    public void deleteFriend(@RequestBody DeleteFriendRequest deleteEvent){
        userService.deleteFriend(deleteEvent.getUserFrom(), deleteEvent.getUserTo());
    }
}