package com.senlainc.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SendMessageRequest {

    @NotEmpty
    private String content;

    @NotNull
    private Long userFrom;

    @NotNull
    private Long userTo;
}
