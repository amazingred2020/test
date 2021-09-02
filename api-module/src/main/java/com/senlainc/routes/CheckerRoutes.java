package com.senlainc.routes;

public interface CheckerRoutes {

    String MAKER = "/maker";
    String CHECKER = "/checker";
    String PRODUCT_BY_ID = CHECKER + "/{id}";
    String PRODUCTS = CHECKER + "/all";
}
