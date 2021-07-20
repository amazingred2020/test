package com.senlainc;

import com.senlainc.entity.User;
import com.senlainc.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LogManager.getLogger();

	@Autowired
	private UserService userService;

    @PostMapping(value="/new")
    public User addUser(@RequestBody User user){
    	User saveUser = userService.saveUser(user);
    	//logger.debug(String.format("Пользователь %s успешно сохранен", saveUser.toString()));
        return saveUser;
    }

    @GetMapping(value = "/find/{id}")
    public User findUserById(@PathVariable Long id){
        User user = userService.findUserById(id);
        logger.debug(String.format("Найденный пользователь с id = %d : %s", id, user.toString()));
        return user;
    }

    @GetMapping(value = "/friend/add")
    public void addFriend(@RequestParam Long userId, @RequestParam Long friendId){
        userService.addFriend(userId, friendId);
    }

    @GetMapping(value = "/friend/delete")
    public void deleteFriend(@RequestParam Long userId, @RequestParam Long friendId){
        userService.deleteFriend(userId, friendId);
    }
}