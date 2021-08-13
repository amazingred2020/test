package com.senlainc.mappers.group;

import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.Group;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-13T17:59:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Override
    public Group fromGroupRequestToGroup(SaveGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        Group group = new Group();

        group.setName( request.getName() );
        group.setDescription( request.getDescription() );

        return group;
    }
}
