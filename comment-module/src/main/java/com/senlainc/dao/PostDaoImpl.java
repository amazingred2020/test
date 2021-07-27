package com.senlainc.dao;

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
        return null;
    }

    @Override
    public Post findById(Long id) {
        return entityManager.find(Post.class, id);
    }

    @Override
    public void remove(Long id) {
    }
}
