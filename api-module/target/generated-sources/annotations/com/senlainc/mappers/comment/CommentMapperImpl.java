package com.senlainc.mappers.comment;

import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.entity.Comment;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-20T12:03:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Autowired
    private CommentById commentById;
    @Autowired
    private PostById postById;
    @Autowired
    private UserById userById;

    @Override
    public Comment fromSaveCommentRequestToComment(SaveCommentRequest request) {
        if ( request == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setUser( userById.fromIdToUser( request.getUserId() ) );
        comment.setPost( postById.fromIdToPost( request.getPostId() ) );
        comment.setParent( commentById.fromIdToComment( request.getParentId() ) );
        comment.setContent( request.getContent() );

        return comment;
    }
}
