package com.senlainc.entity;

import com.senlainc.builder.MessageBuilder;

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

    public Message(MessageBuilder messageBuilder) {
        this.content = messageBuilder.getContent();
        this.userFromId = messageBuilder.getFromId();
        this.userToId = messageBuilder.getToId();
        if(this.createdAt == null){
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
}

