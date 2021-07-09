package com.senlainc;

import com.senlainc.controller.CategoryController;
import com.senlainc.controller.UserController;
import com.senlainc.entity.Category;
import com.senlainc.entity.User;
import com.senlainc.service.category.CategoryService;
import com.senlainc.service.category.CategoryServiceImpl;
import com.senlainc.service.user.UserService;
import com.senlainc.service.user.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();

        UserController userController = new UserController(userService);
        CategoryController categoryController = new CategoryController(categoryService);

        User userTest = new User(args[2], "Фамилия" + Math.random() * 400, "город" + Math.random() * 500);
        Category categoryTest = new Category(args[2]);

        switch (args[0]) {
            case "uc":
                if (args[1].equals("1"))
                    userController.addUser(userTest);
                else
                    System.out.println(userController.findUserById(Long.valueOf(args[2])));

                break;
            case "cc":
                if (args[1].equals("1"))
                    categoryController.addCategory(categoryTest);
                else
                    System.out.println(categoryController.findCategoryById(Long.valueOf(args[2])));

                break;
        }
    }
}
