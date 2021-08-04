package com.senlainc.dto.privileges;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
public class NewRoleRequest {

    @NotEmpty
    private String roleName;
    private List<String> grants;
}
