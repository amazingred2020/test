package com.senlainc;

import com.senlainc.builder.MessageBuilder;
import com.senlainc.entity.Message;
import com.senlainc.service.MessageService;

public class Sender {

    private MessageService messageService;

    public void sendMessage(String content, Long to, Long from){
        Message message = new MessageBuilder().addContent(content).addToId(to).addFromId(from).build();
        messageService.saveMessage(message);
    }

    public void setMessageService(MessageService messageService){
        this.messageService = messageService;
    }

}
