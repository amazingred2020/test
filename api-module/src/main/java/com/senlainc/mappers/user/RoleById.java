package com.senlainc.mappers.user;

import com.senlainc.dao.RoleDao;
import com.senlainc.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleById {

    @Autowired
    private RoleDao roleDao;

    public Role fromIdToRole(Long id){
        return roleDao.findById(id);
    }
}
