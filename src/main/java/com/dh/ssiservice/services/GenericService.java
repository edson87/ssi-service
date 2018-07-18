package com.dh.ssiservice.services;


import com.dh.ssiservice.model.Category;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();
    T findById(Long id);
    T save(T model);
    void deleteById(Long id);
}
