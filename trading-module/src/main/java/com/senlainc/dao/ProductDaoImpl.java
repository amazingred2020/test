package com.senlainc.dao;

import com.senlainc.dao.ProductDao;
import com.senlainc.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        if(product.getId() == null){
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }

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
}
