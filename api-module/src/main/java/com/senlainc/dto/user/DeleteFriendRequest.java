package com.senlainc.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class DeleteFriendRequest {

    @NotNull
    private Long userFrom;
    @NotNull
    private Long userTo;
}
