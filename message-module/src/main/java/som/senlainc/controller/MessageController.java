package som.senlainc.controller;

import com.senlainc.dto.message.SendMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/send")
    public Message sendMessage(@RequestBody @Valid SendMessageRequest request, BindingResult result){
        if(!result.hasErrors()){
            return messageService.sendMessage(request);
        }
        return null;
    }
}
