package com.senlainc.service;

import com.senlainc.entity.Privilege;

public interface PrivilegeService {

    Privilege savePrivilege(Privilege grant);
    Privilege findPrivilegeById(Long id);
    void deletePrivilege(Long id);
}
