package com.senlainc.service.privilege;

import com.senlainc.dao.PrivilegeDao;
import com.senlainc.dao.RoleDao;
import com.senlainc.dto.privileges.SaveRoleRequest;
import com.senlainc.entity.Role;
import com.senlainc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PrivilegeDao privilegeDao;

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
    public void createNewRole(SaveRoleRequest request) {
        Role newRole = new Role(request.getRoleName());
        for(String s: request.getPrivileges()){
            newRole.addGrant(privilegeDao.findPrivilegeByName(s));
        }
        roleDao.save(newRole);
    }

    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
