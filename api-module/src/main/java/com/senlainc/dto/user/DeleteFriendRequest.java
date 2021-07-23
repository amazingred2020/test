package com.senlainc.dto.user;

public class DeleteFriendRequest {

    private Long userFrom;
    private Long userTo;

    public DeleteFriendRequest(){
    }


    public Long getUserTo() {
        return userTo;
    }

    public Long getUserFrom() {
        return userFrom;
    }
}
