package com.senlainc.mappers.product;

import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-13T17:59:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product fromSaveProductRequestToProduct(SaveProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( request.getName() );
        product.setDescription( request.getDescription() );
        product.setPrice( request.getPrice() );

        return product;
    }
}
