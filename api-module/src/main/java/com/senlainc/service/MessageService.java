package com.senlainc.service;

import com.senlainc.dto.message.GetMessageRequest;
import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(SaveMessageRequest request);
    List<Message> findByParameters(GetMessageRequest request);
}
