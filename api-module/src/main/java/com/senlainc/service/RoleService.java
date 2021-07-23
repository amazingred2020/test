package com.senlainc.service;

import com.senlainc.entity.Role;

public interface RoleService {

    Role saveRole(Role role);
    Role findRoleById(Long id);
}
