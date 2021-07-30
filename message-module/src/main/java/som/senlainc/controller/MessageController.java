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

import java.util.List;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/send")
    public Message sendMessage(@RequestBody @Validated SendMessageRequest request){
        return messageService.sendMessage(request);
    }

    @PostMapping(value = "/criteria")
    public List<Message> findByCriteria(@RequestBody @Validated MessageCriteriaRequest request){
        return messageService.findByCriteria(request);
    }
}
