package com.senlainc.dao.user;


import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedEntityGraph;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

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
        return entityManager.find(User.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("select u from User u join fetch u.role where u.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public List<User> findByParameters(String name, String surname) {
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

    @Override
    public Optional<List<User>> getUsersByTextSearch(String firstName, String lastName, String city) {
        Query users = entityManager.createNativeQuery("select *\n" +
                "from users u\n" +
                "where make_tsvector(u.first_name, u.last_name, u.city) @@ " +
                "to_tsquery('" + firstName + " | " + lastName + " | " + city + "')\n" +
                "order by ts_rank(make_tsvector(u.first_name, u.last_name, u.city), " +
                "to_tsquery('" + firstName + " | " + lastName + " | " + city + "'))", User.class);
        return Optional.ofNullable(users.getResultList());
    }

    @Override
    public List<User> getPaginatedUserList(int pageNumber, int pageSize){
        Query query = entityManager.createQuery("from User");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public Optional<User> findByAnyId(Long id){
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAllFriends(Long id) {
        Query users = entityManager.createNativeQuery("select * from users as u " +
                "where u.id in (select f.friend_id from friendship as f where f.user_id = :id)", User.class)
                .setParameter("id", id);
        return users.getResultList();
    }
}

