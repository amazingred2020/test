package som.senlainc.dao;

import com.senlainc.dao.MessageDao;
import com.senlainc.entity.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Message save(Message message) {
        if(message.getId() == null){
            entityManager.persist(message);
        } else {
            entityManager.merge(message);
        }

        return message;
    }

    @Override
    public Message findById(Long id) {
        return entityManager.find(Message.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }
}
