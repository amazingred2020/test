package com.senlainc.dao;

import com.senlainc.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Post> getPostsByProfileId(long profileId) {
        Optional<List<Post>> optional = Optional.ofNullable(entityManager.createQuery("select p from Post p " +
                "where p.profileId = :id", Post.class).setParameter("id", profileId).getResultList());
        if(optional.isPresent()){
            return optional.get();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Post> getPostsByGroupId(long groupId) {
        Optional<List<Post>> optional = Optional.ofNullable(entityManager.createQuery("select p from Post p " +
                "where p.group.id = :id", Post.class).setParameter("id", groupId).getResultList());
        if(optional.isPresent()){
            return optional.get();
        }
        return new ArrayList<>();
    }


}
