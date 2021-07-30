package com.senlainc.dto.user;

import com.senlainc.entity.Status;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddFriendRequest {

    @NotNull
    private Long userFrom;
    @NotNull
    private Long userTo;
    @NotNull
    private Status status;

    public AddFriendRequest(Long userFrom, Long userTo, Status status){
        this.userTo = userTo;
        this.userFrom = userFrom;
        this.status = status;
    }
}
