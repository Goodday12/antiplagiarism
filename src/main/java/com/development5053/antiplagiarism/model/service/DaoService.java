package com.development5053.antiplagiarism.model.service;

import java.util.List;
import java.util.Optional;

public interface DaoService<T> {

    T findByName(String name);

    List<T> findAll();

    Optional<T> getById(long id);

    void save(T t);

    void delete(T t);

}
