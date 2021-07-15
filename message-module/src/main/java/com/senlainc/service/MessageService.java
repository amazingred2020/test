package com.senlainc.service;

import com.senlainc.entity.Message;

public interface MessageService {

    Message saveMessage(Message message);
    void deleteMessage(Long id);
    Message findById(Long id);
}
