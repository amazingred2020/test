package com.senlainc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_invite")
public class GroupInvite{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_from_id")
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "user_to_id")
    private User userTo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Status status;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group groupId;

    public GroupInvite(){
    }

    public GroupInvite(User userFrom, User userTo, Status status){
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
