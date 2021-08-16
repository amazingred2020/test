package com.senlainc.mappers.invite;

import com.senlainc.entity.FriendInvite;
import com.senlainc.mappers.comment.UserById;
import org.mapstruct.Mapper;

@Mapper(uses = {UserById.class})
public interface FriendInviteMapper {

    FriendInvite fromIdsToFriendInvite(Long userFrom, Long userTo);
}
