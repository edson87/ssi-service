package com.dh.ssiservice.repository;


import com.dh.ssiservice.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<List<Item>> findByCode(String code);
}