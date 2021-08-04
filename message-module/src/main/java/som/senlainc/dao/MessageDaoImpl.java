package som.senlainc.dao;

import com.senlainc.dao.MessageDao;
import com.senlainc.entity.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<Message> findMessagesByCriteries(LocalDateTime dateTime, boolean borderDate) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);
        if(borderDate){
            query.where(builder.lessThanOrEqualTo(
                    root.get("createdAt"), dateTime));
        } else {
            query.where(builder.greaterThanOrEqualTo(root.get("createdAt"), dateTime));
        }
        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
