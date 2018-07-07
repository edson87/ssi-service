package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Category;
import com.dh.ssiservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        //itera el categoryRepository, usa un lambda
        categoryRepository.findAll().iterator().forEachRemaining(category -> {
            categories.add(category);
        });
        return categories;
    }

    @Override
    public List<Category> findByCode(String code) {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findByCode(code).get().iterator().forEachRemaining(category -> {
            categories.add(category);
        });
        return categories;
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<Category> categories;
        categories = categoryRepository.findById(id);
        return categories;
    }
}
