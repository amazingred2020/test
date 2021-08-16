package com.senlainc.mappers.group;

import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.Group;
import com.senlainc.mappers.comment.UserById;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserById.class})
public interface GroupMapper {

    @Mapping(source = "request.userId", target = "user")
    Group fromGroupRequestToGroup(SaveGroupRequest request);
}
