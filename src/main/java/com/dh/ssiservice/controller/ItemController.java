package com.dh.ssiservice.controller;

import com.dh.ssiservice.model.Item;
import com.dh.ssiservice.model.SubCategory;
import com.dh.ssiservice.services.ItemService;
import com.dh.ssiservice.services.SubCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/items")
public class ItemController {
    //private ItemRepository itemRepository;
    private ItemService itemService;
    private SubCategoryService subCategoryService;

    public ItemController(ItemService itemService, SubCategoryService subCategoryService) {
        this.itemService = itemService;
        this.subCategoryService = subCategoryService;
    }

/* @RequestMapping("/items")
         public String getItems(Model model){
             model.addAttribute("items",itemRepository.findAll());
             return "items";
         }*/

    @RequestMapping
    public String getItems(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "items";
    }

    @RequestMapping("/{id}")
    public String getItemId(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "item";
    }

    @RequestMapping("/new")
    public String newItem(Model model, Item item) {
        Item newItem = new Item();
        newItem.setSubCategory(new SubCategory());
        model.addAttribute("item", newItem);
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "itemForm";
    }

    @PostMapping
    public String saveItem(Model model, Item item) {
        Item itemPersisted = itemService.save(item);
        model.addAttribute("item", itemPersisted);

        return "redirect:/items/" + itemPersisted.getId();
    }

    @RequestMapping("/update/{id}")
    public String updateItem(Model model, @PathVariable String id){
        model.addAttribute("item",itemService.findById(Long.valueOf(id)));
        model.addAttribute("subCategories",subCategoryService.findAll());
        deteleItem(model,  id);
        return "itemForm";
    }

    @RequestMapping("/delete/{id}")
    public String deteleItem(Model model, @PathVariable String id){
        itemService.deleteById(Long.valueOf(id));
        return"redirect:/items/";
    }
}
