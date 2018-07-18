package com.dh.ssiservice.controller;

import com.dh.ssiservice.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    //private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping
    public String getCategories(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute("categories", StringUtils.isEmpty(code) ?
                categoryService.findAll():
                categoryService.findByCode(code));
        return "categories";
    }

    @RequestMapping("/{id}")
    public String getCategoriesById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category";
    }
}
