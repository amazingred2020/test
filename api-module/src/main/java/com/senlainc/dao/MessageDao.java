package com.senlainc.dao;

import com.senlainc.entity.Message;

public interface MessageDao {

    Message save(Message message);
    Message findById(Long id);
    void remove(Long id);
}
