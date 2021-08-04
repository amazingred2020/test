package com.senlainc.controller;

import com.senlainc.UserRoutes;
import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.DeleteFriendRequest;
import com.senlainc.dto.user.UserCriteriaRequest;
import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.User;
import com.senlainc.principal.CustomGrantedAuthority;
import com.senlainc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

    @PostMapping(UserRoutes.USER)
    public User addUser(@RequestBody @Validated UserRequest request){
        return userService.saveUser(request);
    }

    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping(value = "/role/{userId}/{roleId}")
    private void changeUserRole(@PathVariable Long userId, @PathVariable Long roleId){
        userService.changeRole(userId, roleId);
    }

    @GetMapping("/user/test")
    public void test(Authentication authentication){
        authentication.getPrincipal();
        for(GrantedAuthority authority: authentication.getAuthorities()){
            System.out.println(authority.getAuthority());
        }
    }

    @PostMapping(value = "/criteria")
    public List<User> findUsersByCriteria(@RequestBody @Validated UserCriteriaRequest request){
        return userService.findUsersByCriteria(request);
    }

    @GetMapping(value = "/friend/{id}")
    public Set<User> getAllFriends(@PathVariable("id") Long userId){
        return userService.findUserById(userId).getFriends();
    }

    @PostMapping(value = "/friend/add")
    public void addFriend(@RequestBody @Validated AddFriendRequest request){
        userService.addFriend(request);
    }

    @PostMapping(value = "/friend/delete")
    public void deleteFriend(@RequestBody @Validated DeleteFriendRequest deleteEvent){
        userService.deleteFriend(deleteEvent.getUserFrom(), deleteEvent.getUserTo());
    }
}