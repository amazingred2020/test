package com.senlainc.dao;

import com.senlainc.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

        return findById(comment.getId());
    }

    @Override
    public Comment findById(Long id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public List<Comment> getCommentsByPostId(long id) {
        return entityManager.createQuery("select c from Comment c join fetch c.post p where p.id = :id", Comment.class)
                .setParameter("id", id).getResultList();
    }
}
