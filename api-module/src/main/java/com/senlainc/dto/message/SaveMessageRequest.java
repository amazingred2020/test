package com.senlainc.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class SaveMessageRequest {

    @NotEmpty
    private String content;

    @Min(1)
    private long userFrom;

    @Min(1)
    private long userTo;
}
