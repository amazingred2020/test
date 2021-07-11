package com.senlainc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.senlainc.entity.Message;
import com.senlainc.util.EMUtility;

import java.time.LocalDateTime;

public class MessageDao {
	private EntityManager em = EMUtility.getEntityManager();

    public void save(Message message){
      try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          em.persist(message);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EMUtility.close();
      }
    }

    public Message findById(Long id){
      Message message;
      try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          message = em.find(Message.class, id);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EMUtility.close();
      }
      return message;
    }

    public void updateMessage(Message message){
      try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          message.setUpdatedAt(LocalDateTime.now());
          em.merge(message);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EMUtility.close();
      }
    }

    public void deleteMessage(Long id){
      try {
        EntityTransaction t = em.getTransaction();
        try {
          t.begin();
          Message message = findById(id);
          em.remove(message);
          t.commit();
        } finally {
          if (t.isActive()) t.rollback();
        }
      } finally {
        em.close();
        EMUtility.close();
      }
    }
}
