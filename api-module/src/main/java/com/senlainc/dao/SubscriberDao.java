package com.senlainc.dao;

import com.senlainc.entity.Subscriber;

public interface SubscriberDao {
    void save(Subscriber subscriber);
    void delete(Long groupId, Long userId);

    Subscriber findByUserAndGroupId(long userId, long groupId);
}
