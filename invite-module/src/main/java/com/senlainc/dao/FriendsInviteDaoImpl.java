package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
    public List<FriendInvite> findInvitesByUserId(Long userId) {
        return entityManager.createQuery("select fi from FriendInvite fi where fi.userTo.id = :id", FriendInvite.class)
                .setParameter("id", userId).getResultList();
    }

    @Override
    public Optional<FriendInvite> findInvitesByUsersId(Long userFrom, Long userTo) {
        return entityManager.createQuery("select fi from FriendInvite fi " +
                "where fi.userFrom.id = :idFrom and fi.userTo.id = :idTo", FriendInvite.class)
                .setParameter("idFrom", userFrom).setParameter("idTo", userTo)
                .setMaxResults(1).getResultList().stream().findFirst();
    }

}
