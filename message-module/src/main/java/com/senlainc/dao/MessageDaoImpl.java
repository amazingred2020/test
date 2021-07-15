package com.senlainc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.senlainc.entity.Message;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Message save(Message message){
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.persist(message);
        t.commit();

        return message;
    }

    public Message findById(Long id){
        return entityManager.find(Message.class, id);
    }

    public Message updateMessage(Message message){
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        message.setUpdatedAt(LocalDateTime.now());
        entityManager.merge(message);
        t.commit();

        return message;
    }

    public void deleteMessage(Long id){
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        Message message = findById(id);
        entityManager.remove(message);
        t.commit();
    }
}
