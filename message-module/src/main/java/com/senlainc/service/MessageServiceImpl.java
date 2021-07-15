package com.senlainc.service;

import com.senlainc.dao.MessageDao;
import com.senlainc.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDao messageDao;

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

    @Transactional(readOnly = true)
    @Override
    public Message findById(Long id) {
        return messageDao.findById(id);
    }

}
