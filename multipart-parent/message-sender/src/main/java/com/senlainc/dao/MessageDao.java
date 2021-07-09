package com.senlainc.dao;

import com.senlainc.entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class MessageDao {
    private final EntityManager em = Persistence.createEntityManagerFactory("socialdbunit").createEntityManager();

    private EntityManager getEntityManager(){
        return em;
    }

    public void save(Message message){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
    }

    public Message findById(Long id){
        EntityManager em = getEntityManager();
        return em.find(Message.class, id);
    }

    public Message updateMessage(Message message){
        message.setUpdatedAt(LocalDateTime.now());
        return getEntityManager().merge(message);
    }

    public void deleteMessage(Long id){
        Message m = findById(id);
        getEntityManager().remove(m);
    }
}
