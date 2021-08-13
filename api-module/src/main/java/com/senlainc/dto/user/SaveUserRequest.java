package com.senlainc.dto.user;

import com.senlainc.enums.EnumNamePattern;
import com.senlainc.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserRequest {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @EnumNamePattern(regexp = "MAN|WOMAN")
    private Gender gender;
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
