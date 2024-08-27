package local.app.service;

import local.app.exception.BadWordException;
import local.app.model.Feedback;
import local.app.repository.FeedbackRepositoryInterface;
import local.app.utils.BadWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class FeedbackService implements FeedbackServiceInterface {
    private final FeedbackRepositoryInterface feedbackRepositoryInterface;

    public FeedbackService(FeedbackRepositoryInterface feedbackRepositoryInterface) {
        this.feedbackRepositoryInterface = feedbackRepositoryInterface;
    }

    @Override
    public void save(Feedback feedback) throws BadWordException {
        filterBadWord(feedback);
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

    private void filterBadWord(Feedback feedback) throws BadWordException {
        for(String word : BadWord.BAD_WORD_LIST) {
            if(feedback.getComment().toLowerCase().contains(word.toLowerCase())) {
                throw new BadWordException();
            }
        }
    }
}
