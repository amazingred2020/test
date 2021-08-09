package com.senlainc.dao;

import com.senlainc.entity.Privilege;

public interface PrivilegeDao {

    Privilege save(Privilege privilege);
    Privilege findById(Long id);
    void delete(Long id);
    Privilege findPrivilegeByName(String name);
}
