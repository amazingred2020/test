package com.senlainc.dto.privileges;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaveRoleRequest {

    @NotEmpty
    private String roleName;
    private List<String> privileges;
}
