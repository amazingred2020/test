package com.senlainc.dao.privilege;

import com.senlainc.dao.PrivilegeDao;
import com.senlainc.entity.Privilege;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PrivilegeDaoImpl implements PrivilegeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Privilege save(Privilege grant) {
        if(grant.getId() == null){
            entityManager.persist(grant);
        } else {
            entityManager.merge(grant);
        }

        return grant;
    }

    @Override
    public Privilege findById(Long id) {
        return entityManager.find(Privilege.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public Privilege findPrivilegeByName(String name) {
        return entityManager.createQuery("select p from Privilege p where p.name = :name", Privilege.class)
                .setParameter("name", name).getSingleResult();
    }
}
