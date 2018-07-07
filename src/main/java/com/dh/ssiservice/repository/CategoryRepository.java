package com.dh.ssiservice.repository;


import com.dh.ssiservice.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<List<Category>> findByCode(String firstName);
}