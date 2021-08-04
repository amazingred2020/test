package com.senlainc.dto.user;

import com.senlainc.entity.Status;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class AddFriendRequest {

    @NotNull
    private Long userFrom;

    @NotNull
    private Long userTo;

    @NotEmpty
    private String buttonName;
}
