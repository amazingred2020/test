package com.senlainc.dao;

import com.senlainc.entity.Friendship;

public interface FriendshipDao {

    void save(Friendship friendship);
    void deleteFriend(Long userId, Long friendId);

    Friendship getFriendship(long fromId, long toId);
}
