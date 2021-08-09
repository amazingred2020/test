package com.senlainc.dto.group;
;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class NewGroupRequest {

    @NotEmpty
    private String name;

    @NotNull
    private Long userId;

    private String description;
}
