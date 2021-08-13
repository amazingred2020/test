package com.senlainc.routes;

public interface InviteRoutes {

    String INVITE = "/invite";
    String FRIEND = "/friend";
    String GROUP = "/group";
    String FRIEND_INVITE = INVITE + FRIEND + "/{fromId}/{toId}";
    String FRIEND_INVITIES = INVITE + FRIEND + "/{userId}";
    String GROUP_INVITE = INVITE + GROUP;
    String GROUP_INVITIES = INVITE + GROUP + "/{id}";
}
