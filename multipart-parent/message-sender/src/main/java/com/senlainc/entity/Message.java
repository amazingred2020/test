package com.senlainc.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user_from_id", nullable = false)
    private Long userFromId;

    @Column(name = "user_to_id", nullable = false)
    private Long userToId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Message(){
    }

    private Message(MessageBuilder messageBuilder) {
        this.content = messageBuilder.getContent();
        this.userFromId = messageBuilder.getFromId();
        this.userToId = messageBuilder.getToId();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void seContent(String content) {
    	this.content = content;
    }
    
    public Long getId() {
    	return id;
    }
    
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userFromId=" + userFromId +
                ", userToId=" + userToId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
    
    @Getter
    public static class MessageBuilder {

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
}

