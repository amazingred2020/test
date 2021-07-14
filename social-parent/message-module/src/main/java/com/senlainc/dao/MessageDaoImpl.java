package com.senlainc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.senlainc.entity.Message;
import com.senlainc.util.EntityManagerUtility;

import java.time.LocalDateTime;

public class MessageDaoImpl implements MessageDao {
	private EntityManager entityManager;

    public Message save(Message message){
        entityManager = EntityManagerUtility.getEntityManager();
        try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                entityManager.persist(message);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }
        return message;
    }

    public Message findById(Long id){
        entityManager = EntityManagerUtility.getEntityManager();
        Message message;
        try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                message = entityManager.find(Message.class, id);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }
        return message;
    }

    public Message updateMessage(Message message){
        entityManager = EntityManagerUtility.getEntityManager();
        try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                message.setUpdatedAt(LocalDateTime.now());
                entityManager.merge(message);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }
        return message;
    }

    public void deleteMessage(Long id){
        entityManager = EntityManagerUtility.getEntityManager();
        try {
            EntityTransaction t = entityManager.getTransaction();
            try {
                t.begin();
                Message message = findById(id);
                entityManager.remove(message);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            entityManager.close();
        }
    }
}
