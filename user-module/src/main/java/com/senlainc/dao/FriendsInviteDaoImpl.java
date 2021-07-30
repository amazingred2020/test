package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FriendsInviteDaoImpl implements FriendsInviteDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(FriendInvite friendInvite) {
        entityManager.persist(friendInvite);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public FriendInvite findById(Long id) {
        return entityManager.find(FriendInvite.class, id);
    }

    @Override
    public void deleteByUsersId(Long userFrom, Long userTo) {
        FriendInvite invite = entityManager.createQuery("select fi from FriendInvite fi " +
                        "where fi.userFrom.id = :idFrom and fi.userTo.id = :idTo", FriendInvite.class)
                .setParameter("idFrom", userFrom).setParameter("idTo", userTo).setMaxResults(1).getSingleResult();
        remove(invite.getId());
    }
}
