package com.senlainc.service;

import com.senlainc.dto.message.SendMessageRequest;
import com.senlainc.entity.Message;

public interface MessageService {

    Message saveMessage(Message message);
    void deleteMessage(Long id);
    Message sendMessage(SendMessageRequest request);
}
