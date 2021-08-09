package com.senlainc.routes;

public interface PostRoutes {

    String POST = "/post";
    String POST_CATEGORY = POST + "/category";
    String DELETE_POST = POST + "/{postId}";
    String UPDATE_POST = POST + "/edit";
    String DELETE_POST_CATEGORY = POST + POST_CATEGORY + "/{id}";
}
