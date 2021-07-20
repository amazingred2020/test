package com.senlainc.entity;

import com.senlainc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender{

    @Autowired
    private MessageService messageService;

    public void sendMessage(String content, Long to, Long from){
        Message message = new Message.MessageBuilder().addContent(content).addToId(to).addFromId(from).build();
        messageService.saveMessage(message);
    }

    public void editMessage(Long messageId, String content, Long to, Long from){
        Message message = new Message.MessageBuilder().addMessageId(messageId).addContent(content).addToId(to).addFromId(from).build();
        messageService.saveMessage(message);
    }
}
