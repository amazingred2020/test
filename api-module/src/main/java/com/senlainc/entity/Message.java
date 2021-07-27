package com.senlainc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_from_id")
    private User userFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_to_id")
    private User userTo;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Message(){
    }

    public Message(String content){
        this.content = content;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", createdAt=" + createdAt +
                '}';
    }
}

