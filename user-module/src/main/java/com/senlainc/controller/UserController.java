package com.senlainc.controller;

import com.senlainc.entity.User;
import com.senlainc.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private Logger logger = LogManager.getLogger();

	@Autowired
	private UserService userService;

    public void addUser(User user){
    	User saveUser = userService.saveUser(user);
    	logger.info(String.format("Пользователь %s успешно сохранен", saveUser.toString()));
    }

    public void findUserById(Long id){
        User user = userService.findUserById(id);
        logger.info(String.format("Найденный пользователь с id = %d : %s", id, user.toString()));
    }
}