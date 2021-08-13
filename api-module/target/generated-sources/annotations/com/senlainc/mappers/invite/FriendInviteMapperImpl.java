package com.senlainc.mappers.invite;

import com.senlainc.entity.FriendInvite;
import com.senlainc.mappers.comment.UserByIdMapper;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-13T17:59:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class FriendInviteMapperImpl implements FriendInviteMapper {

    @Autowired
    private UserByIdMapper userByIdMapper;

    @Override
    public FriendInvite fromIdsToFriendInvite(Long userFrom, Long userTo) {
        if ( userFrom == null && userTo == null ) {
            return null;
        }

        FriendInvite friendInvite = new FriendInvite();

        if ( userFrom != null ) {
            friendInvite.setUserFrom( userByIdMapper.fromIdToUser( userFrom ) );
        }
        if ( userTo != null ) {
            friendInvite.setUserTo( userByIdMapper.fromIdToUser( userTo ) );
        }

        return friendInvite;
    }
}
