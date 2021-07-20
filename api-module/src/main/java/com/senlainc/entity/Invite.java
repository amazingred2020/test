package com.senlainc.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_from_id", nullable = false)
    private Long userFrom;

    @Column(name = "user_to_id", nullable = false)
    private Long userTo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "created_at", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime createdAt;

    public Invite(){
    }

    public Invite(Long fromId, Long toId, Status status) {
        this.userFrom = fromId;
        this.userTo = toId;
        this.status = status;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
