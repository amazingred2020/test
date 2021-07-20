package com.senlainc.dao;

import com.senlainc.entity.Comment;
import com.senlainc.entity.Post;
import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentDaoImpl implements CommentDao {

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

    public Comment publishComment(Comment comment, Long userId, Long postId){
        comment.setPost(entityManager.find(Post.class, postId));
        comment.setAuthor(entityManager.find(User.class, userId));
        return save(comment);
    }

    @Override
    public void remove(Long id) {
        Comment comment = entityManager.find(Comment.class, id);
        if(comment != null){
            entityManager.remove(comment);
        }
    }

}
