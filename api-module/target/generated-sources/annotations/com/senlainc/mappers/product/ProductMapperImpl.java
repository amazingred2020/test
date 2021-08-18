package com.senlainc.mappers.product;

import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.mappers.comment.UserById;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-18T13:02:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private UserById userById;

    @Override
    public Product fromSaveProductRequestToProduct(SaveProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setUser( userById.fromIdToUser( request.getUserId() ) );
        product.setName( request.getName() );
        product.setDescription( request.getDescription() );
        product.setPrice( request.getPrice() );

        return product;
    }
}
