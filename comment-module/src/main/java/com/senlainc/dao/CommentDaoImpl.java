package com.senlainc.dao;

import com.senlainc.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentDaoImpl implements CommentDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Comment save(Comment comment) {
        if(comment.getId() == null){
            entityManager.persist(comment);
        } else {
            entityManager.merge(comment);
        }

        return comment;
    }

    @Override
    public Comment findById(Long id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }
}
