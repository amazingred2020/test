package com.senlainc.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "friend_invite")
public class FriendInvite{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_from_id")
    private User userFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_to_id")
    private User userTo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public FriendInvite(){
    }

    public FriendInvite(User fromId, User toId, Status status){
        this.userFrom = fromId;
        this.userTo = toId;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Long getId(){
        return id;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

}

