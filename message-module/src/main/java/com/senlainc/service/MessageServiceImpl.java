package com.senlainc.service;

import com.senlainc.factory.ComponentFactory;
import com.senlainc.dao.MessageDao;
import com.senlainc.entity.Message;


public class MessageServiceImpl implements MessageService{

    private MessageDao messageDao;

    public MessageServiceImpl(){
        this.messageDao = ComponentFactory.getInstance().getComponent(MessageDao.class);
    }

    @Override
    public Message saveMessage(Message message) {
        if(message.getId() == null) {
        	return messageDao.save(message);
        }
        else {
        	return messageDao.updateMessage(message);
        }
    }

    @Override
    public void deleteMessage(Long id) {
        messageDao.deleteMessage(id);
    }

    @Override
    public Message findById(Long id) {
        return messageDao.findById(id);
    }

}
