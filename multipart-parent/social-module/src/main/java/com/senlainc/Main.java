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
    	User user1 = new User("���1","�������1","�����1");
    	User user2 = new User("���2","�������2","�����2");
    	service.saveUser(user1);
    	service.saveUser(user2);
    	
    	Sender sender = new Sender();
    	MessageService messageService = new MessageServiceImpl();
    	sender.setMessageService(messageService);

    	sender.sendMessage("User1 ������ ��������� User2", 1L, 2L);
    	sender.sendMessage("User1 ������ ��������� ��������� User2", 1L, 2L);
    	sender.sendMessage("User2 ������� User1", 2L, 1L);
    	
    	System.out.println(messageService.findById(3L));
    	Message thirdMessage = messageService.findById(2L);
    	thirdMessage.seContent("��������� ������ ���������");
    	messageService.saveMessage(thirdMessage);
    	System.out.println(messageService.findById(2L));
    }
}
