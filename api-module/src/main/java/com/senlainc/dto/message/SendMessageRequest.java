package com.senlainc.dto.message;

import javax.validation.constraints.NotNull;

public class SendMessageRequest {

    @NotNull
    private String content;

    @NotNull
    private Long userFrom;

    @NotNull
    private Long userTo;

    public SendMessageRequest(){
    }

    public String getContent() {
        return content;
    }

    public Long getUserFrom() {
        return userFrom;
    }

    public Long getUserTo() {
        return userTo;
    }
}
