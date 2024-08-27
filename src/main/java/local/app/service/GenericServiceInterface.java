package local.app.service;

import local.app.exception.BadWordException;
import local.app.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericServiceInterface<T> {

    void save(T t) throws BadWordException;

    Page<T> findAll(Pageable pageable);

    T findById(Long id);
}
