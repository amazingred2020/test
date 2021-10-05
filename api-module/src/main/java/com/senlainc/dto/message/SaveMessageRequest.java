package com.senlainc.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SaveMessageRequest {

    @NotEmpty
    private String content;

    @Min(1)
    private long userFrom;

    @Min(1)
    private long userTo;
}
