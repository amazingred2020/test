package com.senlainc.controller;

import com.senlainc.dto.message.GetMessageRequest;
import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.routes.MessageRoutes;
import com.senlainc.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(MessageRoutes.MESSAGE)
    public Message sendMessage(@RequestBody @Validated SaveMessageRequest request){
        return messageService.sendMessage(request);
    }

    @PostMapping(MessageRoutes.MESSAGE_BY_PARAMS)
    public List<Message> findByParameters(@RequestBody @Validated GetMessageRequest request){
        return messageService.findByParameters(request);
    }

    @GetMapping(MessageRoutes.PAGINATION)
    public List<Message> getPaginatedList(@PathVariable int page, @PathVariable int size){
        return messageService.getPaginatedProductList(page, size);
    }
}
