package com.senlainc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.enums.Status;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Status status;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Generated(GenerationTime.INSERT)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public GroupInvite(User userFrom, User userTo, Group group){
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.group = group;
    }
}
