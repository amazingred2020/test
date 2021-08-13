package com.senlainc.mappers.invite;

import com.senlainc.dto.invite.SaveGroupInviteRequest;
import com.senlainc.entity.GroupInvite;
import com.senlainc.mappers.comment.UserByIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserByIdMapper.class, GroupByIdMapper.class})
public interface GroupInviteMapper {

    GroupInvite fromSaveGroupInviteRequestToGroup(SaveGroupInviteRequest request);
}
