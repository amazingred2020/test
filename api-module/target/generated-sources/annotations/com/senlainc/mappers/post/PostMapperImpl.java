package com.senlainc.mappers.post;

import com.senlainc.dto.post.SavePostRequest;
import com.senlainc.entity.Post;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-13T17:59:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post fromSavePostRequestToPost(SavePostRequest request) {
        if ( request == null ) {
            return null;
        }

        Post post = new Post();

        post.setContent( request.getContent() );

        return post;
    }
}
