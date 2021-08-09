package som.senlainc.controller;

import com.senlainc.dto.message.MessageCriteriaRequest;
import com.senlainc.dto.message.SendMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import som.senlainc.routes.MessageRoutes;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(MessageRoutes.MESSAGE)
    public Message sendMessage(@RequestBody @Validated SendMessageRequest request){
        System.out.println("ПРИШЕДШИЙ РЕКВЕСТ ПОСЫЛКИ СООБЩЕНИЯ:");
        System.out.println(request);
        return messageService.sendMessage(request);
    }

    @PostMapping(MessageRoutes.FIND_MESSAGE)
    public List<Message> findByCriteria(@RequestBody @Validated MessageCriteriaRequest request){
        System.out.println("ПРИШЕДШИЙ РЕКВЕСТ ПОИСКА ПО КРИТЕРИЮ:");
        System.out.println(request);
        return messageService.findByCriteria(request);
    }
}
