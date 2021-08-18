package com.senlainc.dao;

import com.senlainc.entity.Role;

public interface RoleDao {

    Role save(Role role);
    Role findById(Long id);
    void delete(Long id);

    Role findByName(String name);
}
