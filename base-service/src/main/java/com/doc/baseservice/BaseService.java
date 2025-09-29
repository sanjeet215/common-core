package com.doc.baseservice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {

    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void delete(ID id);
    T update(ID id, T entity);
}
