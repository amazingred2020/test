package com.senlainc.routes;

public interface UserRoutes {
    String USER = "/users";
    String USER_BY_ID = USER + "/{id}";
    String FRIEND = "/friend";
    String USER_BY_PARAMS = USER + "/find";
    String USER_TEXT_SEARCH = USER + "/search";
    String USER_FRIEND = USER + FRIEND;
    String PAGINATION = USER + "/pagination/{page}/{size}";
    String ALL_FRIENDS = USER_FRIEND + "/{id}";
    String CHANGE_ROLE = USER + "/{userId}/{roleId}";
}
