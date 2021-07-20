package com.senlainc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "friend_invite")
public class FriendInvite extends Invite{

    public FriendInvite(){
    }

    public FriendInvite(Long fromId, Long toId, Status status){
        super(fromId, toId, status);
    }
}
