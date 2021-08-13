package com.senlainc.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class GetUserRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;
}
