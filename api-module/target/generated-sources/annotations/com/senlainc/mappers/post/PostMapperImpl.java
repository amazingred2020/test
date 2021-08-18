package com.senlainc.mappers.post;

import com.senlainc.dto.post.SavePostRequest;
import com.senlainc.entity.Post;
import com.senlainc.mappers.comment.UserById;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-18T13:02:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Autowired
    private UserById userById;
    @Autowired
    private CategoryById categoryById;

    @Override
    public Post fromSavePostRequestToPost(SavePostRequest request) {
        if ( request == null ) {
            return null;
        }

        Post post = new Post();

        post.setUser( userById.fromIdToUser( request.getUserId() ) );
        post.setCategory( categoryById.fromIdToCategory( request.getCategoryId() ) );
        post.setContent( request.getContent() );

        return post;
    }
}
