package com.senlainc.routes;

public interface MessageRoutes {

    String MESSAGE = "/message";
    String MESSAGE_BY_PARAMS = MESSAGE + "/find";
    String PAGINATION = MESSAGE + "/{page}/{size}";
}
