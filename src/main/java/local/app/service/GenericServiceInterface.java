package local.app.service;

import java.util.List;

public interface GenericServiceInterface<T> {
    List<T> findAll();

    T findById(int id);

    void save(T t);

    void delete(T t);
}
