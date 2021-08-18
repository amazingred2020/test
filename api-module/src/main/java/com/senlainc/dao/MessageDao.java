package com.senlainc.dao;

import com.senlainc.entity.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageDao {

    Message save(Message message);
    Message findById(Long id);
    void remove(Long id);
    List<Message> findMessagesByParameters(LocalDateTime dateTime, boolean borderDate);

    List<Message> getPaginatedMessageList(int page, int size);
}
