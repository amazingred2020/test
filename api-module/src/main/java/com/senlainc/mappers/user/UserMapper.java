package com.senlainc.mappers.user;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.entity.Friendship;
import com.senlainc.entity.User;
import com.senlainc.mappers.comment.UserById;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {RoleById.class, UserById.class})
public interface UserMapper {

    @Mapping(source = "request.roleId", target = "role")
    User userSaveUserRequestToUser(SaveUserRequest request);

    @Mapping(source = "request.userFrom", target = "user")
    @Mapping(source = "request.userTo", target = "friend")
    Friendship fromAddFriendRequestToFriendShip1(AddFriendRequest request);

    @Mapping(source = "request.userFrom", target = "friend")
    @Mapping(source = "request.userTo", target = "user")
    Friendship fromAddFriendRequestToFriendShip2(AddFriendRequest request);
}
