package local.app.repository;

import local.app.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FeedbackRepositoryInterface extends PagingAndSortingRepository<Feedback, Long> {
    Page<Feedback> findAll(Pageable pageable);
}
