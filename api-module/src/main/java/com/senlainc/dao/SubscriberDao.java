package com.senlainc.dao;

import com.senlainc.entity.Subscriber;
import com.senlainc.entity.User;

import java.util.List;

public interface SubscriberDao {
    void save(Subscriber subscriber);
    void delete(Long groupId, Long userId);
    Subscriber findByUserAndGroupId(long userId, long groupId);
    List<User> getAllSubscribers(long id);
}
