package local.app.service;

import local.app.model.Feedback;
import local.app.repository.FeedbackRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements FeedbackServiceInterface {
    @Autowired
    private FeedbackRepositoryInterface feedbackRepositoryInterface;

    @Override
    public void save(Feedback feedback) {
        feedbackRepositoryInterface.save(feedback);
    }

    @Override
    public Page<Feedback> findAll(Pageable pageable) {
        return feedbackRepositoryInterface.findAll(pageable);
    }

    @Override
    public Feedback findById(Long id) {
        return feedbackRepositoryInterface.findById(id).get();
    }
}
