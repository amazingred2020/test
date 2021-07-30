package com.senlainc.dto.privileges;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class NewRoleRequest {

    @NotEmpty
    private String roleName;
    @NotEmpty
    private String grantOne;
    private String grantTwo;
    private String grantThree;
    private String grantFour;
}
