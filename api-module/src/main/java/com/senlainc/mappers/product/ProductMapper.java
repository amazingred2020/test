package com.senlainc.mappers.product;

import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.mappers.comment.UserByIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserByIdMapper.class})
public interface ProductMapper {

    Product fromSaveProductRequestToProduct(SaveProductRequest request);
}
