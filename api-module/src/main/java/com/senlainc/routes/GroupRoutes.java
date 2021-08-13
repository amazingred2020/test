package com.senlainc.routes;

public interface GroupRoutes {

    String GROUP = "/group";
    String GROUP_BY_ID = GROUP + "/{id}";
    String USER_IN = GROUP + "/add";
    String USER_OUT = GROUP + "/delete";
}
