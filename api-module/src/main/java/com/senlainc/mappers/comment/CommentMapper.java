package com.senlainc.mappers.comment;

import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(uses = {CommentByIdMapper.class, PostByIdMapper.class, UserByIdMapper.class})
public interface CommentMapper {

    Comment fromSaveCommentRequestToComment(SaveCommentRequest request);

    Comment fromUpdateCommentRequestToComment(UpdateCommentRequest request);
}
