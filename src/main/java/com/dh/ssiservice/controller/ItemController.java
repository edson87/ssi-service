package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.ItemRepository;
import com.dh.ssiservice.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/items")
public class ItemController {
    //private ItemRepository itemRepository;
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /* @RequestMapping("/items")
         public String getItems(Model model){
             model.addAttribute("items",itemRepository.findAll());
             return "items";
         }*/
    @RequestMapping
    public String getItems(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute("items", StringUtils.isEmpty(code) ?
                itemService.getItem() :
                itemService.findByCode(code));
        return "items";
    }

    @RequestMapping("/{id}")
    public String getItemId(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("item", itemService.findById(id).get());
        return "item";
    }
}
