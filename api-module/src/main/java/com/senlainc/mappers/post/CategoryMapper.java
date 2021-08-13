package com.senlainc.mappers.post;

import com.senlainc.entity.Category;

public interface CategoryMapper {

    Category fromParametersToCategory(String name, Long parentId);
}
