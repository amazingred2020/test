package com.senlainc.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SendMessageRequest {

    @NotEmpty
    private String content;

    @NotNull
    private Long userFrom;

    @NotNull
    private Long userTo;
}
