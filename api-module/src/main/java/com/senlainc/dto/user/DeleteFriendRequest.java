package com.senlainc.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Getter
@NoArgsConstructor
public class DeleteFriendRequest {

    @Min(1)
    private long userFrom;
    @Min(1)
    private long userTo;
}
