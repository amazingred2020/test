package com.senlainc;

import com.senlainc.container.factory.ComponentFactory;
import com.senlainc.app.controller.CategoryController;
import com.senlainc.app.controller.UserController;
import com.senlainc.app.entity.Category;
import com.senlainc.app.entity.User;
import com.senlainc.app.service.CategoryService;
import com.senlainc.app.service.CategoryServiceImpl;
import com.senlainc.app.service.UserService;
import com.senlainc.app.service.UserServiceImpl;

public class App {
  public static void main(String[] args) {
	  
	User user1 = new User("Имя1","Фамилия1","Название города1");  
	User user2 = new User("Имя2","Фамилия2","Название города2");
	
	UserService userService = new UserServiceImpl();
	userService.saveUser(user1);
	
	Category сategory1 = new Category("Название категории1", 3L);
	Category сategory2 = new Category("Название категории2", 3L);
	
	CategoryService categoryService = new CategoryServiceImpl();
	categoryService.saveCategory(сategory1);
	  
    CategoryController categoryController = new CategoryController();
    categoryController.addCategory(сategory2);
    categoryController.findCategoryById(1L);
    
    UserController userController = new UserController();
    userController.addUser(user2);
    userController.findUserById(2L);

    ComponentFactory.getInstance().getComponentFinder().checkImplementationMap();
  }
}
