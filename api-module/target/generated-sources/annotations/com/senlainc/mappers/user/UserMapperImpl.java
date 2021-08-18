package com.senlainc.mappers.user;

import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.entity.User;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-18T13:02:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleById roleById;

    @Override
    public User userSaveUserRequestToUser(SaveUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setRole( roleById.fromIdToRole( request.getRoleId() ) );
        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        user.setGender( request.getGender() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setEmail( request.getEmail() );
        user.setCity( request.getCity() );

        return user;
    }
}
