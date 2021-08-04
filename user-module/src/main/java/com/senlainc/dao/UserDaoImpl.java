package com.senlainc.dao;


import com.senlainc.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Log4j2
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User save(User user){
        if(user.getId() == null){
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
      
        return user;
    }

    public User findById(Long id){
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void addFriend(Long userId, Long friendId) {
        findById(userId).addFriend(findById(friendId));
    }

    @Override
    public void deleteFriend(Long userId, Long friendId) {
        findById(userId).deleteFriend(findById(friendId));
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username).getSingleResult();

    }

    @Override
    public List<User> findByCriteries(String name, String surname) {
        String temp1 = name;
        String temp2 = surname;
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Predicate predicateForName = builder.equal(
                root.get("firstName"), name);
        Predicate predicateFromSurname = builder.equal(
                root.get("lastName"), surname);
        Predicate predicate = builder.or(
                predicateForName,
                predicateFromSurname);
        query.where(predicate);
        query.orderBy(
                builder.desc(root.get("firstName")),
                builder.asc(root.get("lastName")));
        return entityManager.createQuery(query).getResultList();
    }
}

