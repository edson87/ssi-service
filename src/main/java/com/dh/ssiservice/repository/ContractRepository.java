package com.dh.ssiservice.repository;


import com.dh.ssiservice.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Category, Long> {

}