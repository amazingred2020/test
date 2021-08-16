package com.senlainc.mappers.user;

import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = RoleById.class)
public interface UserMapper {

    @Mapping(source = "request.roleId", target = "role")
    User userSaveUserRequestToUser(SaveUserRequest request);
}
