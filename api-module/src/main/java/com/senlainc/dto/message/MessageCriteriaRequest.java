package com.senlainc.dto.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MessageCriteriaRequest {

    @NotNull
    @Past
    private LocalDateTime dateTime;
    @NotNull
    private Boolean border;
}
