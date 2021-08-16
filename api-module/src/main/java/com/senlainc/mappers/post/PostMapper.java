package com.senlainc.mappers.post;

import com.senlainc.dto.post.SavePostRequest;
import com.senlainc.entity.Post;
import com.senlainc.mappers.comment.UserById;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserById.class, CategoryById.class})
public interface PostMapper {

    @Mapping(source = "request.userId", target = "user")
    @Mapping(source = "request.categoryId", target = "category")
    Post fromSavePostRequestToPost(SavePostRequest request);
}
