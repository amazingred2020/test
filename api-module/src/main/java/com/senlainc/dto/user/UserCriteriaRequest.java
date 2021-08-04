package com.senlainc.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class UserCriteriaRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;
}
