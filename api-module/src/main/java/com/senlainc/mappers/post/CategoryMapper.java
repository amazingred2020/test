package com.senlainc.mappers.post;

import com.senlainc.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CategoryById.class)
public interface CategoryMapper {

    @Mapping(source = "parentId", target = "parent")
    Category fromParametersToCategory(String name, Long parentId);
}
