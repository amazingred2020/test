package com.senlainc.routes;

public interface MessageRoutes {

    String MESSAGE = "/message";
    String MESSAGE_BY_PARAMS = MESSAGE + "/find";
    String PAGINATION = MESSAGE + "/pagination/{page}/{size}";
    String DIALOGS = MESSAGE + "/dialogs/{id}";
    String DIALOG = MESSAGE + "/dialog/{one}/{two}";
}
