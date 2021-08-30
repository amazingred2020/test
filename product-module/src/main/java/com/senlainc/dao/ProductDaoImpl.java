package com.senlainc.dao;

import com.senlainc.entity.Post;
import com.senlainc.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product findByName(String name) {
        return entityManager.createQuery("select p from Product p where p.name = :name", Product.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Product> getPaginatedUserList(int pageNumber, int pageSize) {
        Query query = entityManager.createQuery("from Product");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllProducts() {
        return entityManager.createQuery("select p from Product p join fetch p.user", Product.class).getResultList();
    }
}