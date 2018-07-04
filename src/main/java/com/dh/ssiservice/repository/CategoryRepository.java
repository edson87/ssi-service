package com.dh.ssiservice.repository;


import org.springframework.data.repository.CrudRepository;
import com.dh.ssiservice.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}