package com.senlainc.dao.user;

import com.senlainc.dao.FriendshipDao;
import com.senlainc.entity.Friendship;
import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FriendshipDaoImpl implements FriendshipDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Friendship friendship){
        if(friendship.getId() == null){
            entityManager.persist(friendship);
        } else {
            entityManager.merge(friendship);
        }
    }

    @Override
    public void deleteFriend(Long userId, Long friendId) {
        entityManager.createQuery("delete from Friendship f where f.user.id = :userId " +
                "and f.friend.id = :friendId")
                .setParameter("userId", userId)
                .setParameter("friendId", friendId)
                .executeUpdate();
    }

    @Override
    public Friendship getFriendship(long fromId, long toId){
        return entityManager.createQuery("select f from Friendship f join fetch f.friend where f.user.id = :userFrom " +
                "and f.friend.id = :friendId", Friendship.class)
                .setParameter("userFrom", fromId)
                .setParameter("friendId", toId)
                .getSingleResult();
    }
}
