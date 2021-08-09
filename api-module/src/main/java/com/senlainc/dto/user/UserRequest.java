package com.senlainc.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Max(7)
    private String gender;
    @NotEmpty
    private String username;
    @NotEmpty
    @Min(10)
    private String password;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String city;
    private Long roleId;
}
