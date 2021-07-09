package com.senlainc.controller;

import com.senlainc.entity.Category;
import com.senlainc.entity.User;
import com.senlainc.service.user.UserService;

public class UserController {

    private UserService us;

    public UserController(UserService service){
        us = service;
    }

    public String addUser(User user){
        us.saveUser(user);
        return "Пользователь "+ user.getFullName() + "\" успешно сохранена!";
    }

    public User findUserById(Long id){
        return us.findUserById(id);
    }
}
