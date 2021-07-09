package com.senlainc.builder;

import com.senlainc.entity.Message;

public class MessageBuilder {

    private String content;
    private Long fromId;
    private Long toId;

    public String getContent() {
        return content;
    }

    public Long getFromId() {
        return fromId;
    }

    public Long getToId() {
        return toId;
    }

    public MessageBuilder addContent(String content) {
        this.content = content;
        return this;
    }

    public MessageBuilder addFromId(Long fromId) {
        this.fromId = fromId;
        return this;
    }

    public MessageBuilder addToId(Long toId) {
        this.toId = toId;
        return this;
    }

    public Message build() {
        return new Message(this);
    }
}
