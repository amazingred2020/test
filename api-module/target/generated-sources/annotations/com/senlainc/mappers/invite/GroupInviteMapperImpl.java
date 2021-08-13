package com.senlainc.mappers.invite;

import com.senlainc.dto.invite.SaveGroupInviteRequest;
import com.senlainc.entity.GroupInvite;
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
public class GroupInviteMapperImpl implements GroupInviteMapper {

    @Autowired
    private UserByIdMapper userByIdMapper;

    @Override
    public GroupInvite fromSaveGroupInviteRequestToGroup(SaveGroupInviteRequest request) {
        if ( request == null ) {
            return null;
        }

        GroupInvite groupInvite = new GroupInvite();

        groupInvite.setUserFrom( userByIdMapper.fromIdToUser( request.getUserFrom() ) );
        groupInvite.setUserTo( userByIdMapper.fromIdToUser( request.getUserTo() ) );
        groupInvite.setStatus( request.getStatus() );

        return groupInvite;
    }
}
