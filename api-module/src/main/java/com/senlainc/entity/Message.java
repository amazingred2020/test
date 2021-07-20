package com.senlainc.entity;

import lombok.Getter;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
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

    @Column(name = "created_at", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    private LocalDateTime updatedAt;

    public Message(){
    }

    private Message(MessageBuilder messageBuilder) {
        if(messageBuilder.getId() != null){
            this.id = messageBuilder.getId();
        }
        this.content = messageBuilder.getContent();
        this.userFromId = messageBuilder.getFromId();
        this.userToId = messageBuilder.getToId();
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void seContent(String content) {
    	this.content = content;
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

        private Long id;
        private String content;
        private Long fromId;
        private Long toId;

        public MessageBuilder addMessageId(Long id){
            this.id = id;
            return this;
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

