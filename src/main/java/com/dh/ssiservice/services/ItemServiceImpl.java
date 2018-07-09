package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Item;
import com.dh.ssiservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository ;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItem() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().iterator().forEachRemaining(item -> {items.add(item);});
        return items;
    }

    @Override
    public List<Item> findByCode(String code) {
        List<Item> items = new ArrayList<>();
        itemRepository.findByCode(code).get().iterator().forEachRemaining(items::add);
        return items;
    }

    @Override
    public Optional<Item> findById(Long id) {
        Optional<Item> items;
        items = itemRepository.findById(id);
        return items;
    }
}
