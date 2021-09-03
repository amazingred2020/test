package com.senlainc.dao;

import com.senlainc.entity.ProductChecker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CheckerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ProductChecker productChecker){
        if(productChecker.getId() == null){
            entityManager.persist(productChecker);
        } else {
            entityManager.merge(productChecker);
        }
    }

    public Optional<List<ProductChecker>> getAllPendingProducts(){
        return Optional.ofNullable(entityManager.createQuery("select pc from ProductChecker pc" +
                " where pc.checkerStatus = 'PENDING'", ProductChecker.class).getResultList());
    }

    public ProductChecker getById(Long id) {
        return entityManager.find(ProductChecker.class, id);
    }


}
