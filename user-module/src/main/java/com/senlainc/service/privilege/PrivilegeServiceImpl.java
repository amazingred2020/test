package com.senlainc.service.privilege;

import com.senlainc.dao.PrivilegeDao;
import com.senlainc.entity.Privilege;
import com.senlainc.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    public Privilege savePrivilege(Privilege privilege) {
        return privilegeDao.save(privilege);
    }

    @Override
    public Privilege findPrivilegeById(Long id) {
        return privilegeDao.findById(id);
    }

    @Override
    public void deletePrivilege(Long id) {
        privilegeDao.delete(id);
    }
}
