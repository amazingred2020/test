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
    @Size(max = 7)
    private String gender;
    @NotEmpty
    private String username;
    @NotEmpty
    @Size(min = 10)
    private String password;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String city;
    private Long roleId;
}
