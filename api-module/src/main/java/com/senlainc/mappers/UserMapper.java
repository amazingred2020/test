package com.senlainc.mappers;

import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userSaveUserRequestToUser(SaveUserRequest request);
}
