package com.senlainc.mappers.comment;

import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-13T17:59:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment fromSaveCommentRequestToComment(SaveCommentRequest request) {
        if ( request == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setContent( request.getContent() );

        return comment;
    }

    @Override
    public Comment fromUpdateCommentRequestToComment(UpdateCommentRequest request) {
        if ( request == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setContent( request.getContent() );

        return comment;
    }
}
