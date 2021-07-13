package com.senlainc.app.controller;

import com.senlainc.container.annotation.InjectComponent;
import com.senlainc.container.factory.ComponentFactory;
import com.senlainc.app.entity.User;
import com.senlainc.app.service.UserService;

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