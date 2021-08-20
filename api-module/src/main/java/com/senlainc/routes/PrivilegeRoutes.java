package com.senlainc.routes;

public interface PrivilegeRoutes {

    String ROLE = "/role";
    String PRIVILEGE = "/privilege";
    String ROLE_BY_ID = ROLE + "/{id}";
    String PRIVILEGE_BY_ID = PRIVILEGE + "/{id}";
}
