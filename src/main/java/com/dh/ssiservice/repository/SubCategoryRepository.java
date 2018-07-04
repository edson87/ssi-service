package com.dh.ssiservice.repository;


import com.dh.ssiservice.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface SubCategoryRepository extends CrudRepository<Category, Long> {

}