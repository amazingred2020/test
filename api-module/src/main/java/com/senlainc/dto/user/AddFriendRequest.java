package com.senlainc.dto.user;

import com.senlainc.entity.Status;

public class AddFriendRequest {

    private Long userFrom;
    private Long userTo;
    private Status status;

    public AddFriendRequest(){
    }

    public Long getUserFrom() {
        return userFrom;
    }

    public Long getUserTo() {
        return userTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
