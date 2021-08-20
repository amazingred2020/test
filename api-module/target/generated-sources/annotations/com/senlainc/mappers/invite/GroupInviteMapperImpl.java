package com.senlainc.mappers.invite;

import com.senlainc.dto.invite.SaveGroupInviteRequest;
import com.senlainc.entity.GroupInvite;
import com.senlainc.mappers.comment.UserById;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-20T12:03:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class GroupInviteMapperImpl implements GroupInviteMapper {

    @Autowired
    private UserById userById;
    @Autowired
    private GroupById groupById;

    @Override
    public GroupInvite fromSaveGroupInviteRequestToGroup(SaveGroupInviteRequest request) {
        if ( request == null ) {
            return null;
        }

        GroupInvite groupInvite = new GroupInvite();

        groupInvite.setUserFrom( userById.fromIdToUser( request.getUserFrom() ) );
        groupInvite.setUserTo( userById.fromIdToUser( request.getUserTo() ) );
        groupInvite.setGroup( groupById.fromIdToGroup( request.getGroupId() ) );
        groupInvite.setStatus( request.getStatus() );

        return groupInvite;
    }
}
