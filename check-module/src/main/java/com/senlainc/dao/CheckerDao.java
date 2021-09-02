package com.senlainc.dao;

import com.senlainc.entity.ProductChecker;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CheckerDao {

    private Logger LOGGER = Logger.getLogger(CheckerDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ProductChecker productChecker){
        System.out.println("ВНУТРИ CHECKER DAO SAVE!");
        LOGGER.info(productChecker);
        System.out.println("ПРИШЕДШИЙ НА СОХРАНЕНИЕ: "+productChecker);
        entityManager.persist(productChecker);
    }

    public Optional<List<ProductChecker>> getAllPendingProducts(){
        return Optional.ofNullable(entityManager.createQuery("select pc from ProductChecker pc" +
                " where pc.checkerStatus = 'PENDING'", ProductChecker.class).getResultList());
    }

    public ProductChecker getById(Long id) {
        return entityManager.find(ProductChecker.class, id);
    }


}
