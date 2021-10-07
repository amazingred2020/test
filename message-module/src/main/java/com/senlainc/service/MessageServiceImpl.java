package com.senlainc.service;

import com.senlainc.dao.MessageDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.message.GetMessageRequest;
import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.entity.User;
import com.senlainc.enums.AopMarker;
import com.senlainc.mappers.message.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Message sendMessage(SaveMessageRequest request) {
        Message newMessage = messageMapper.fromSaveMessageRequestToMessage(request);
        return messageDao.save(newMessage);
    }

    @Override
    public List<Message> findByParameters(GetMessageRequest request) {
        return messageDao.findMessagesByParameters(request.getDateTime(), request.getBorderDate());
    }

    @Override
    public List<Message> getPaginatedProductList(int page, int size) {
        return messageDao.getPaginatedMessageList(page, size);
    }

    @Override
    public List<User> getAllDialogs(long id){
        return messageDao.getAllDialogs(id);
    }

    @Override
    public List<Message> getDialogMessages(long userOneId, long userTwoId) {
        return messageDao.getDialogMessages(userOneId, userTwoId);
    }
}
