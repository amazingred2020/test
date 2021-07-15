package com.senlainc;

import com.senlainc.factory.ComponentFactory;
import com.senlainc.entity.Message;
import com.senlainc.service.MessageService;

public class Sender {

    private MessageService messageService;

    public Sender(){
        this.messageService = ComponentFactory.getInstance().getComponent(MessageService.class);
    }

    public void sendMessage(String content, Long to, Long from){
        Message message = new Message.MessageBuilder().addContent(content).addToId(to).addFromId(from).build();
        messageService.saveMessage(message);
    }

    public void editMessage(Long messageId, String content, Long to, Long from){
        Message message = new Message.MessageBuilder().addMessageId(messageId).addContent(content).addToId(to).addFromId(from).build();
        messageService.saveMessage(message);
    }
}
