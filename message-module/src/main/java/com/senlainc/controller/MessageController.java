package com.senlainc.controller;

import com.senlainc.dto.message.GetMessageRequest;
import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.entity.User;
import com.senlainc.routes.MessageRoutes;
import com.senlainc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(MessageRoutes.DIALOGS)
    public List<User> getAllDialogs(@PathVariable long id){
        return messageService.getAllDialogs(id);
    }

    @GetMapping(MessageRoutes.DIALOG)
    public List<Message> getSingleDialog(@PathVariable("one") long userOneId, @PathVariable("two") long userTwoId){
        return messageService.getDialogMessages(userOneId, userTwoId);
    }
}
