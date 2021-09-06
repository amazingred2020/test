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
    public Privilege save(Privilege privilege) {
        if(privilege.getId() == null){
            entityManager.persist(privilege);
        } else {
            entityManager.merge(privilege);
        }

        return privilege;
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
        return entityManager.createQuery("select g from Privilege g where g.name = :name", Privilege.class)
                .setParameter("name", name).getSingleResult();
    }
}
