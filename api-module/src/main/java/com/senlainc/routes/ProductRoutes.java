package com.senlainc.routes;

public interface ProductRoutes {

    String PRODUCT = "/product";
    String BUY_PRODUCT = PRODUCT + "/{productId}/{userId}";
    String PAGINATION = PRODUCT + "/pagination/{page}/{size}";
}
