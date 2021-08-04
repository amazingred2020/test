package com.senlainc.mappers;

import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-04T18:20:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

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
