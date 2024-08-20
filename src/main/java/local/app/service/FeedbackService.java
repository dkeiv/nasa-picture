package local.app.service;

import local.app.model.Feedback;
import local.app.repository.FeedbackRepository;
import local.app.repository.FeedbackRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class FeedbackService implements FeedbackServiceInterface {
    @Autowired
    private FeedbackRepositoryInterface feedbackRepositoryInterface;

    @Override
    public void delete(Feedback feedback) {

    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepositoryInterface.findAll();
    }

    @Override
    public Feedback findById(int id) {
        return null;
    }

    @Override
    public void save(Feedback feedback) {
        feedbackRepositoryInterface.save(feedback);
    }
}
