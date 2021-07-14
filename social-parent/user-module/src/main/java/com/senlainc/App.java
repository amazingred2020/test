package com.senlainc;

import com.senlainc.controller.CategoryController;
import com.senlainc.entity.Category;
import com.senlainc.factory.ComponentFactory;
import com.senlainc.controller.UserController;
import com.senlainc.entity.User;
import com.senlainc.service.*;

public class App {
    public static void main(String[] args) {

	    User user1 = new User("Имя1","Фамилия1","Название города1", 3l);
	    User user2 = new User("Имя2","Фамилия2","Название города2", 1l);
	
	    UserService userService = new UserServiceImpl();
	    userService.saveUser(user1);

		UserController userController = new UserController();
		userController.addUser(user2);
		userController.addUser(new User("Имя3","Фамилия3","Название города3"));
		userController.findUserById(2L);

	    Category сategory1 = new Category("Название категории1");
	    Category сategory2 = new Category("Название категории2", 1l);
	
	    CategoryService categoryService = new CategoryServiceImpl();
	    categoryService.saveCategory(сategory1);
	  
        CategoryController categoryController = new CategoryController();
        categoryController.addCategory(сategory2);
        categoryController.addCategory(new Category("Название категории3", 2l));
        categoryController.findCategoryById(1L);

        Sender messageSender = new Sender();
        messageSender.sendMessage("Сообщение от user1 пользователю user2", 1l, 2l);
        messageSender.sendMessage("Сообщение от user1 пользователю user2", 1l, 2l);
        messageSender.sendMessage("user2 ответил пользователю user1", 2l, 1l);

        MessageService messageService = new MessageServiceImpl();
        System.out.println(messageService.findById(2l));
        messageSender.editMessage(2l, "сообщение отредактировано",1l, 2l);
        System.out.println(messageService.findById(2l));
        messageService.deleteMessage(2l);


        ComponentFactory.getInstance().getComponentFinder().checkImplementationMap();
  }
}
