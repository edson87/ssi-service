package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getItem();
    List<Item> findByCode(String code);
    Optional<Item> findById(Long id);
}
