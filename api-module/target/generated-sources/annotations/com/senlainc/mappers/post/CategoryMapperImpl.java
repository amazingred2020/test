package com.senlainc.mappers.post;

import com.senlainc.entity.Category;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-18T13:02:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Autowired
    private CategoryById categoryById;

    @Override
    public Category fromParametersToCategory(String name, Long parentId) {
        if ( name == null && parentId == null ) {
            return null;
        }

        Category category = new Category();

        if ( name != null ) {
            category.setName( name );
        }
        if ( parentId != null ) {
            category.setParent( categoryById.fromIdToCategory( parentId ) );
        }

        return category;
    }
}
