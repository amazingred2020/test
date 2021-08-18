package com.senlainc.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class UpdatePostRequest {

    @Min(1)
    private long postId;

    @NotEmpty
    private String content;

    private Long categoryId;
}