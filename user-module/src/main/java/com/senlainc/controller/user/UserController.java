package com.senlainc.controller.user;

import com.senlainc.dto.user.*;
import com.senlainc.routes.UserRoutes;
import com.senlainc.entity.User;
import com.senlainc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

    @PostMapping(UserRoutes.USER)
    public User addUser(@RequestBody @Validated SaveUserRequest request){
        return userService.saveUser(request);
    }

    @GetMapping(UserRoutes.USER_BY_ID)
    public User findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PutMapping(UserRoutes.CHANGE_ROLE)
    private void changeUserRole(@PathVariable Long userId, @PathVariable Long roleId){
        userService.changeRole(userId, roleId);
    }

    @PostMapping(UserRoutes.USER_BY_PARAMS)
    public List<User> findUsersByParameters(@RequestBody @Validated GetUserRequest request){
        return userService.findUsersByParameters(request);
    }

    @GetMapping(UserRoutes.ALL_FRIENDS)
    public Set<User> getAllFriends(@PathVariable("id") Long userId){
        return userService.findUserById(userId).getFriends();
    }

    @PostMapping(UserRoutes.USER_FRIEND)
    public void addFriend(@RequestBody @Validated AddFriendRequest request){
        userService.addFriend(request);
    }

    @DeleteMapping(UserRoutes.USER_FRIEND)
    public void deleteFriend(@RequestBody @Validated DeleteFriendRequest deleteEvent){
        userService.deleteFriend(deleteEvent.getUserFrom(), deleteEvent.getUserTo());
    }

    @PostMapping(UserRoutes.USER_TEXT_SEARCH)
    public List<User> getUsersByTextSearch(@RequestBody @Validated UserTextSearchRequest request){
        return userService.getUsersByTextSearch(request);
    }

}