package com.senlainc.controller;

import com.senlainc.entity.User;
import com.senlainc.service.UserService;
import com.senlainc.annotation.InjectComponent;
import com.senlainc.factory.ComponentFactory;

public class UserController {

	@InjectComponent
	private UserService userService;

	public UserController(){
	    this.userService = ComponentFactory.getInstance().getComponent(UserService.class);
    }

    public void addUser(User user){
    	User saveUser = userService.saveUser(user);
    	System.out.println(String.format("Пользователь %s успешно сохранен", saveUser.toString())); 
    }

    public void findUserById(Long id){
        User user = userService.findUserById(id);
        System.out.println(String.format("Найденный пользователь с id = %d : %s", id, user.toString()));
    }
}