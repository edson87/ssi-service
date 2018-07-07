package com.dh.ssiservice.repository;


import com.dh.ssiservice.model.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
    Optional<List<SubCategory>> findByCode(String code);
}