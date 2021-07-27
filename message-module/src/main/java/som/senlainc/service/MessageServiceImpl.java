package som.senlainc.service;

import com.senlainc.dao.MessageDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.message.SendMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Message saveMessage(Message message) {
        return messageDao.save(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageDao.remove(id);
    }

    @Override
    public Message sendMessage(SendMessageRequest request) {
        Message newMessage = new Message(request.getContent());
        newMessage.setUserFrom(userDao.findById(request.getUserFrom()));
        newMessage.setUserTo(userDao.findById(request.getUserTo()));
        return messageDao.save(newMessage);
    }
}
