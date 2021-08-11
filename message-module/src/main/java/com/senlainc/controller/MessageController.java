package com.senlainc.controller;

import com.senlainc.dto.message.MessageCriteriaRequest;
import com.senlainc.dto.message.SendMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.routes.MessageRoutes;
import com.senlainc.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(MessageRoutes.MESSAGE)
    public Message sendMessage(@RequestBody @Validated SendMessageRequest request){
        return messageService.sendMessage(request);
    }

    @PostMapping(MessageRoutes.FIND_MESSAGE)
    public List<Message> findByCriteria(@RequestBody @Validated MessageCriteriaRequest request){
        return messageService.findByCriteria(request);
    }
}
