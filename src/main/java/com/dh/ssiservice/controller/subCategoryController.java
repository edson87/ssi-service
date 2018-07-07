package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.SubCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/subCategories")
public class subCategoryController {
    private SubCategoryRepository subCategoryRepository;

    public subCategoryController(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    /*@RequestMapping("/subCategories")
    public String getSubCategories(Model model){
        model.addAttribute("subCategories",subCategoryRepository.findAll());
        return "subCategories";
    }*/
    @RequestMapping
    public String getSubCategories(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute("subCategories", StringUtils.isEmpty(code) ? subCategoryRepository.findAll() : subCategoryRepository.findByCode(code).get());
        return "subCategories";
    }

    @RequestMapping("/{id}")
    public String getCategoriesById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("subCategory", subCategoryRepository.findById(id).get());
        return "subCategory";
    }

}
