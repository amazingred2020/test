package com.senlainc.mappers;

import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserRequest request);
}
