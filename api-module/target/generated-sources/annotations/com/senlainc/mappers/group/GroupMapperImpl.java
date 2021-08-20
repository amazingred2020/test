package com.senlainc.mappers.group;

import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.Group;
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
public class GroupMapperImpl implements GroupMapper {

    @Autowired
    private UserById userById;

    @Override
    public Group fromGroupRequestToGroup(SaveGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        Group group = new Group();

        group.setUser( userById.fromIdToUser( request.getUserId() ) );
        group.setName( request.getName() );
        group.setDescription( request.getDescription() );

        return group;
    }
}
