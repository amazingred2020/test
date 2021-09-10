package com.senlainc.dao;

import com.senlainc.entity.Subscriber;
import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SubscriberDaoImpl implements SubscriberDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Subscriber subscriber){
        if(subscriber.getId() == null){
            entityManager.persist(subscriber);
        } else {
            entityManager.merge(subscriber);
        }
    }

    @Override
    public void delete(Long groupId, Long userId) {
        entityManager.createQuery("delete from Subscriber s where s.user.id = :userId " +
                "and s.group.id = :groupId")
                .setParameter("userId", userId)
                .setParameter("groupId", groupId)
                .executeUpdate();
    }

    @Override
    public Subscriber findByUserAndGroupId(long userId, long groupId){
        return entityManager.createQuery("select s from Subscriber s where s.user.id = :userId " +
                "and s.group.id = :groupId", Subscriber.class)
                .setParameter("userId", userId)
                .setParameter("groupId", groupId)
                .getSingleResult();
    }

    @Override
    public List<User> getAllSubscribers(long id) {
        Query query = entityManager.createNativeQuery("select u.* from subscribers as s, users as u, groups as g " +
                "where s.user_id = u.id and s.group_id = g.id and g.id = :id", User.class).setParameter("id", id);
        List<User> users = query.getResultList();
        return users;
    }
}
