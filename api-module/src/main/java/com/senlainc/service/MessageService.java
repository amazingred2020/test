package com.senlainc.service;

import com.senlainc.dto.message.GetMessageRequest;
import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.entity.User;

import java.util.List;

public interface MessageService {

    Message sendMessage(SaveMessageRequest request);
    List<Message> findByParameters(GetMessageRequest request);
    List<Message> getPaginatedProductList(int page, int size);
    List<User> getAllDialogs(long id);
    List<Message> getDialogMessages(long userOneId, long userTwoId);
}
