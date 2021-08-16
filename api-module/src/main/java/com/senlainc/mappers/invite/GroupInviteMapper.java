package com.senlainc.mappers.invite;

import com.senlainc.dto.invite.SaveGroupInviteRequest;
import com.senlainc.entity.GroupInvite;
import com.senlainc.mappers.comment.UserById;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserById.class, GroupById.class})
public interface GroupInviteMapper {

    @Mapping(source = "request.userFrom", target = "userFrom")
    @Mapping(source = "request.userTo", target = "userTo")
    @Mapping(source = "request.groupId", target = "group")
    GroupInvite fromSaveGroupInviteRequestToGroup(SaveGroupInviteRequest request);
}
