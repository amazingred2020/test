package com.senlainc.routes;

public interface CheckerRoutes {

    String VALIDATE = "/maker";
    String CHECKER = "/checker";
    String APPROVE = CHECKER + "/approve/{id}";
    String REJECT = CHECKER + "/reject/{id}";
    String PRODUCT = "/product";
    String PRODUCT_BY_ID = CHECKER + PRODUCT + "/{id}";
    String PRODUCTS = CHECKER + PRODUCT + "/all";
}
