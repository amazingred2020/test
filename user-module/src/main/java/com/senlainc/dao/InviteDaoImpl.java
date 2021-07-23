package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.Invite;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class InviteDaoImpl implements InviteDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveFriendsInvite(FriendInvite friendInvite) {
        if(friendInvite.getId() == null){
            entityManager.persist(friendInvite);
        } else {
            entityManager.merge(friendInvite);
        }
    }

    @Override
    public void deleteFriendInvite(Long id) {
        entityManager.remove(findFriendInviteById(id));
    }

    @Override
    public FriendInvite findFriendInviteById(Long id) {
        return entityManager.find(FriendInvite.class, id);
    }

    @Override
    public void deleteInviteByUserToId(Long userTo) {

    }
}
