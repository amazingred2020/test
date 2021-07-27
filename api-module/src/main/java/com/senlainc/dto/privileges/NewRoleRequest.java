package com.senlainc.dto.privileges;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewRoleRequest {

    @NotNull
    private String roleName;
    @NotNull
    @NotBlank
    private String grantOne;
    private String grantTwo;
    private String grantThree;
    private String grantFour;

    public NewRoleRequest(){
    }

    public String getRoleName() {
        return roleName;
    }

    public String getGrantOne() {
        return grantOne;
    }

    public String getGrantTwo() {
        return grantTwo;
    }

    public String getGrantThree() {
        return grantThree;
    }

    public String getGrantFour() {
        return grantFour;
    }
}
