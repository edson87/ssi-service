package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.ItemRepository;
import com.dh.ssiservice.repository.SubCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class subCategoryController {
    private SubCategoryRepository subCategoryRepository;

    public subCategoryController(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @RequestMapping("/subCategories")
    public String getSubCategories(Model model){
        model.addAttribute("subCategories",subCategoryRepository.findAll());
        return "subCategories";
    }
}
