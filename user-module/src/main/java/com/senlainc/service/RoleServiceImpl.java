package com.senlainc.service;

import com.senlainc.dao.RoleDao;
import com.senlainc.dto.privileges.NewRoleRequest;
import com.senlainc.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional(readOnly = true)
    @Override
    public Role findRoleById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRole(Long id) {
    }

    @Override
    public void createNewRole(NewRoleRequest newRoleRequest) {
    }
}
