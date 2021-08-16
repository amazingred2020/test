package com.senlainc.mappers.product;

import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.mappers.comment.UserById;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserById.class})
public interface ProductMapper {

    @Mapping(source = "request.userId", target = "user")
    Product fromSaveProductRequestToProduct(SaveProductRequest request);
}
