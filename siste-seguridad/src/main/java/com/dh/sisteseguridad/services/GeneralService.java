package com.dh.sisteseguridad.services;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T model);
}
