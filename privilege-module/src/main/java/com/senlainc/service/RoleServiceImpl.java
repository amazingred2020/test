package com.senlainc.service;

import com.senlainc.dao.GrantDao;
import com.senlainc.dao.RoleDao;
import com.senlainc.dto.privileges.NewRoleRequest;
import com.senlainc.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private GrantDao grantDao;

    @Transactional(readOnly = true)
    @Override
    public Role findRoleById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRole(Long id) {
        roleDao.delete(id);
    }

    @Override
    public void createNewRole(NewRoleRequest request) {
        Role newRole = new Role(request.getRoleName());
        newRole.addGrant(grantDao.findGrantByName(request.getGrantOne()));
        if(request.getGrantTwo() != null){
            newRole.addGrant(grantDao.findGrantByName(request.getGrantTwo()));
        }
        if (request.getGrantThree() != null){
            newRole.addGrant(grantDao.findGrantByName(request.getGrantThree()));
        }
        if (request.getGrantFour() != null){
            newRole.addGrant(grantDao.findGrantByName(request.getGrantFour()));
        }
        roleDao.save(newRole);
    }
}
