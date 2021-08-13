package com.senlainc.mappers.message;

import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
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
public class MessageMapperImpl implements MessageMapper {

    @Autowired
    private UserByIdMapper userByIdMapper;

    @Override
    public Message fromSaveMessageRequestToMessage(SaveMessageRequest request) {
        if ( request == null ) {
            return null;
        }

        Message message = new Message();

        message.setContent( request.getContent() );
        message.setUserFrom( userByIdMapper.fromIdToUser( request.getUserFrom() ) );
        message.setUserTo( userByIdMapper.fromIdToUser( request.getUserTo() ) );

        return message;
    }
}
