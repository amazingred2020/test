package com.senlainc.service;

import com.senlainc.dao.MessageDao;
import com.senlainc.entity.Message;


public class MessageServiceImpl implements MessageService{

    private MessageDao md;

    public MessageServiceImpl(){
        this.md = new MessageDao();
    }

    @Override
    public void saveMessage(Message message) {
        if(message.getId() == null) {
        	md.save(message);
        }
        else {
        	md.updateMessage(message);
        }
    }

    @Override
    public void deleteMessage(Long id) {
        md.deleteMessage(id);
    }

    @Override
    public Message findById(Long id) {
        return md.findById(id);
    }

}
