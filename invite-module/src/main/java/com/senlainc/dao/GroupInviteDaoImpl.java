package com.senlainc.dao;

import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GroupInviteDaoImpl implements GroupInviteDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public GroupInvite save(GroupInvite groupInvite) {
        entityManager.persist(groupInvite);
        return groupInvite;
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public GroupInvite findById(Long id) {
        return entityManager.find(GroupInvite.class, id);
    }

    @Override
    public List<GroupInvite> findInvitesByUserId(Long userId) {
        return entityManager.createQuery("select gi from GroupInvite gi where gi.userTo.id = :id", GroupInvite.class)
                .setParameter("id", userId).getResultList();
    }

    @Override
    public GroupInvite findInviteByUsersId(Long fromId, Long userId) {
        return entityManager.createQuery("select gi from GroupInvite gi " +
                "where gi.userFrom.id = :fromId and gi.userTo.id = :toId", GroupInvite.class)
                .setParameter("fromId", fromId).setParameter("toId", userId).setMaxResults(1).getSingleResult();
    }
}
