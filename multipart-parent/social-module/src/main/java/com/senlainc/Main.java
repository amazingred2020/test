package com.senlainc;

import com.senlainc.entity.Message;
import com.senlainc.entity.User;
import com.senlainc.service.MessageService;
import com.senlainc.service.MessageServiceImpl;

import com.senlainc.service.user.UserService;
import com.senlainc.service.user.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
    	UserService service = new UserServiceImpl();
    	User user1 = new User("Имя1","Фамилия1","город1");
    	User user2 = new User("Имя2","Фамилия2","город2");
    	service.saveUser(user1);
    	service.saveUser(user2);
    	
    	Sender sender = new Sender();
    	MessageService messageService = new MessageServiceImpl();
    	sender.setMessageService(messageService);

    	sender.sendMessage("User1 послал сообщение User2", 1L, 2L);
    	sender.sendMessage("User1 послал повторное сообщение User2", 1L, 2L);
    	sender.sendMessage("User2 ответил User1", 2L, 1L);
    	
    	System.out.println(messageService.findById(3L));
    	Message thirdMessage = messageService.findById(2L);
    	thirdMessage.seContent("Изменение текста сообщения");
    	messageService.saveMessage(thirdMessage);
    	System.out.println(messageService.findById(2L));
    }
}
