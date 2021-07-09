package com.senlainc.service;

import com.senlainc.dao.MessageDao;
import com.senlainc.entity.Message;
import com.senlainc.entity.User;


public class MessageServiceImpl implements MessageService{

    private MessageDao md;

    public MessageServiceImpl(){
        this.md = new MessageDao();
    }

    @Override
    public void saveMessage(Message message) {
        md.save(message);
    }

    @Override
    public Message updateMessage(Message message) {
        return md.updateMessage(message);
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
