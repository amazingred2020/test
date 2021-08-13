package com.senlainc.mappers.post;

import com.senlainc.dto.post.SavePostRequest;
import com.senlainc.entity.Post;
import com.senlainc.mappers.comment.UserByIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserByIdMapper.class, CategoryByIdMapper.class})
public interface PostMapper {

    Post fromSavePostRequestToPost(SavePostRequest request);
}
