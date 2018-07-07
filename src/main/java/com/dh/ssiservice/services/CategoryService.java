package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategory();

    List<Category> findByCode(String code);

    Optional<Category> findById(Long id);
}
