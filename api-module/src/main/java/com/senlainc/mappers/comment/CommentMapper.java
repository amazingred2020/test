package com.senlainc.mappers.comment;

import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {CommentById.class, PostById.class, UserById.class})
public interface CommentMapper {

    @Mapping(source = "request.userId", target = "user")
    @Mapping(source = "request.postId", target = "post")
    @Mapping(source = "request.parentId", target = "parent")
    Comment fromSaveCommentRequestToComment(SaveCommentRequest request);
}
