package com.senlainc.mappers.invite;

import com.senlainc.entity.FriendInvite;
import com.senlainc.mappers.comment.UserByIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserByIdMapper.class})
public interface FriendInviteMapper {

    FriendInvite fromIdsToFriendInvite(Long userFrom, Long userTo);
}
