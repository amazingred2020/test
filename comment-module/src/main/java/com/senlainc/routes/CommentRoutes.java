package com.senlainc.routes;

public interface CommentRoutes {

    String COMMENT = "/comment";
    String UPDATE_COMMENT = COMMENT + "/edit";
    String DELETE_COMMENT = COMMENT + "/{id}";
}
