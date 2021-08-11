package com.senlainc.dto.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.senlainc.jpaconfig.ParseDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MessageCriteriaRequest {

    @NotNull
    @Past
    @JsonDeserialize(using = ParseDeserializer.class)
    private LocalDateTime dateTime;
    @NotNull
    private Boolean borderDate;
}
