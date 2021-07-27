package com.senlainc.dto.group;

import javax.validation.constraints.NotNull;

public class GroupUserRequest {

    @NotNull
    private Long groupId;

    @NotNull
    private Long userId;

    private Long userFromId;

    public GroupUserRequest(){
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getUserFromId() {
        return userFromId;
    }
}
