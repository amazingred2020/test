package com.senlainc.service;

import com.senlainc.dto.message.MessageCriteriaRequest;
import com.senlainc.dto.message.SendMessageRequest;
import com.senlainc.entity.Message;

import java.util.List;

public interface MessageService {

    Message saveMessage(Message message);
    void deleteMessage(Long id);
    Message sendMessage(SendMessageRequest request);
    List<Message> findByCriteria(MessageCriteriaRequest request);
}