package com.senlainc.mappers.group;

import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.Group;
import com.senlainc.entity.Subscriber;
import com.senlainc.mappers.comment.UserById;
import com.senlainc.mappers.invite.GroupById;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserById.class, GroupById.class})
public interface GroupMapper {

    @Mapping(source = "request.userId", target = "user")
    Group fromGroupRequestToGroup(SaveGroupRequest request);

    @Mapping(source = "request.userId", target = "user")
    @Mapping(source = "request.groupId", target = "group")
    Subscriber fromGroupUserRequestToSubscriber(GroupUserRequest request);
}
