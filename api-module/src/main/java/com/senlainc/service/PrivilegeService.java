package com.senlainc.service;

import com.senlainc.entity.Privilege;

public interface PrivilegeService {

    Privilege savePrivilege(Privilege privilege);
    Privilege findPrivilegeById(Long id);
    void deletePrivilege(Long id);
}
