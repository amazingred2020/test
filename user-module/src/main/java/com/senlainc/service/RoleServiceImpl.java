package com.senlainc.service;

import com.senlainc.dao.RoleDao;
import com.senlainc.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Role findRoleById(Long id) {
        return roleDao.findById(id);
    }
}
