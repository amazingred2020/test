package com.senlainc.unit.message;

import com.senlainc.dto.message.GetMessageRequest;
import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.MessageService;
import com.senlainc.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testSendMessage(){
        SaveMessageRequest request = new SaveMessageRequest();
        request.setContent("text message");
        request.setUserFrom(1l);
        request.setUserTo(2l);
        Message message = messageService.sendMessage(request);

        Assert.assertTrue("text message".equals(message.getContent()));
    }

    @Test
    public void testFindByParameters(){
        GetMessageRequest request = new GetMessageRequest();
        request.setDateTime(LocalDateTime.of(2018, 9, 19, 14, 5));
        request.setBorderDate(false);
        List<Message> messages = messageService.findByParameters(request);

        Assert.assertFalse(messages.isEmpty());
    }
}
