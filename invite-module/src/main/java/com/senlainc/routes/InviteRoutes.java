package com.senlainc.routes;

public interface InviteRoutes {

    String INVITE = "/invite";
    String FRIEND = "/friend";
    String GROUP = "/group";
    String ADD_FRIEND_INVITE = INVITE + FRIEND + "/{fromId}/{toId}";
    String ALL_FRIEND_INVITES = INVITE + FRIEND + "/{userId}";
    String ADD_GROUP_INVITE = INVITE + GROUP;
    String ALL_GROUP_INVITIES = INVITE + GROUP + "/{id}";
}
