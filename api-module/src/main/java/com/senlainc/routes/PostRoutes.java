package com.senlainc.routes;

public interface PostRoutes {

    String POST = "/post";
    String POST_CATEGORY = POST + "/category";
    String POST_BY_ID = POST + "/{postId}";
    String POST_CATEGORY_BY_ID = POST_CATEGORY + "/{id}";
    String PROFILE_POST = POST + "/profile/{id}";
    String GROUP_POST = POST + "/group/{id}";
}
