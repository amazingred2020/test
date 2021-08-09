package com.senlainc.routes;

public interface GroupRoutes {

    String GROUP = "/group";
    String USER = "/user";
    String DELETE_GROUP = GROUP + "/{id}";
    String CHANGE_ADMIN = GROUP + "/change";
    String ADD_USER_TO_GROUP = GROUP + USER + "/add";
    String DELETE_USER_FROM_GROUP = GROUP + USER + "/delete";
}
