package com.senlainc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.senlainc.entity.Message;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Message save(Message message){
        entityManager.persist(message);;

        return message;
    }

    public Message findById(Long id){
        return entityManager.find(Message.class, id);
    }

    public Message updateMessage(Message message){ ;
        message.setUpdatedAt(LocalDateTime.now());
        entityManager.merge(message);

        return message;
    }

    public void deleteMessage(Long id){
        Message message = findById(id);
        entityManager.remove(message);
    }
}
