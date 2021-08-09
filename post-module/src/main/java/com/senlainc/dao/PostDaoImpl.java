package com.senlainc.dao;

import com.senlainc.entity.Category;
import com.senlainc.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostDaoImpl implements PostDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Post save(Post post) {
        if(post.getId() == null){
            entityManager.persist(post);
        } else {
            entityManager.merge(post);
        }

        return post;
    }

    @Override
    public Post findById(Long id) {
        return entityManager.find(Post.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public Post findByContent(String content) {
        return entityManager.createQuery("select p from Post p where p.content = :content", Post.class)
                .setParameter("content", content).getSingleResult();
    }
}
