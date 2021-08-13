package com.senlainc.mappers.group;

import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.Group;
import com.senlainc.mappers.comment.UserByIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserByIdMapper.class})
public interface GroupMapper {

    Group fromGroupRequestToGroup(SaveGroupRequest request);
}
