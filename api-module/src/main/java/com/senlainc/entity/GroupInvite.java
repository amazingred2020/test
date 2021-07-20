package com.senlainc.entity;

import javax.persistence.*;

@Entity
@Table(name = "group_invite")
public class GroupInvite extends Invite{

    private Long groupId;

    public GroupInvite(){
    }

    public GroupInvite(Long fromId, Long toId, Status status, Long groupId) {
        super(fromId, toId, status);
        this.groupId = groupId;
    }
}
