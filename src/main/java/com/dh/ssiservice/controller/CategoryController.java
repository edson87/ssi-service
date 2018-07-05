package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

}
