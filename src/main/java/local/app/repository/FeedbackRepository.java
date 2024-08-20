package local.app.repository;

import local.app.model.Feedback;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@Transactional
@Repository
public class FeedbackRepository implements FeedbackRepositoryInterface {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(Feedback feedback) {

    }

    @Override
    public List<Feedback> findAll() {
        TypedQuery<Feedback> query = em.createQuery("select fb from Feedback as fb", Feedback.class);
        return query.getResultList();
    }

    @Override
    public Feedback findById(Long id) {
        return null;
    }

    @Override
    public void save(Feedback feedback) {
        if (feedback.getId() == null) {
            em.persist(feedback);
        } else {
            em.merge(feedback);
        }
    }
}
