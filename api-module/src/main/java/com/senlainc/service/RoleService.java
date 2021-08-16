package com.senlainc.service;

import com.senlainc.dto.privileges.SaveRoleRequest;
import com.senlainc.entity.Role;

public interface RoleService {

    Role findRoleById(Long id);
    void deleteRole(Long id);
    void createNewRole(SaveRoleRequest newRoleRequest);;
}
