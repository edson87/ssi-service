package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService extends GenericService<Category> {
    /*List<Category> getCategory();
    List<Category> findByCode(String code);
    Optional<Category> findById(Long id);*/

    List<Category> findByCode(String code);

}
