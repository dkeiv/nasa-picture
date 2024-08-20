package local.app.repository;

import java.util.List;

public interface GenericRepositoryInterface<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(T t);
}
