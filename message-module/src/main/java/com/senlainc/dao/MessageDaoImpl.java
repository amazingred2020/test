package com.senlainc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.senlainc.entity.Message;
import com.senlainc.util.EntityManagerUtility;

import java.time.LocalDateTime;

public class MessageDaoImpl implements MessageDao {
	private EntityManager entityManager = EntityManagerUtility.getEntityManager();

    public Message save(Message message){
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            entityManager.persist(message);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
        }

        return message;
    }

    public Message findById(Long id){
        return entityManager.find(Message.class, id);
    }

    public Message updateMessage(Message message){
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            message.setUpdatedAt(LocalDateTime.now());
            entityManager.merge(message);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
        }

        return message;
    }

    public void deleteMessage(Long id){
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            Message message = findById(id);
            entityManager.remove(message);
            t.commit();
        } catch (Exception exception) {
            t.rollback();
            exception.printStackTrace();
        }
    }
}
