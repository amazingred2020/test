package com.senlainc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "friend_invite")
public class FriendInvite{

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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public FriendInvite(User fromId, User toId, Status status){
        this.userFrom = fromId;
        this.userTo = toId;
        this.status = status;
    }
}

