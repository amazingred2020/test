package com.senlainc.service;

import com.senlainc.dao.GrantDao;
import com.senlainc.entity.Grant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GrantServiceImpl implements  GrantService{

    @Autowired
    private GrantDao grantDao;

    @Override
    public Grant saveGrant(Grant grant) {
        return grantDao.save(grant);
    }

    @Override
    public Grant findGrantById(Long id) {
        return grantDao.findById(id);
    }

    @Override
    public void deleteGrant(Long id) {
        grantDao.delete(id);
    }
}
