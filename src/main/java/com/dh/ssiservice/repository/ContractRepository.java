package com.dh.ssiservice.repository;


import com.dh.ssiservice.model.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Long> {
    //Optional<List<Contract>> findByCode(String code);
}