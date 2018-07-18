package com.dh.ssiservice.controller;

import com.dh.ssiservice.model.Item;
import com.dh.ssiservice.model.SubCategory;
import com.dh.ssiservice.services.ItemService;
import com.dh.ssiservice.services.SubCategoryService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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
       //deteleItem(model,  id);
        return "itemForm";
    }

    @RequestMapping("/delete/{id}")
    public String deteleItem(Model model, @PathVariable String id){
        itemService.deleteById(Long.valueOf(id));
        return"redirect:/items/";
    }

    @RequestMapping(value = "/{id}/image")
    public String showUploadItemImageForm(Model model, @PathVariable String id) {
        Item itemPersisted = itemService.findById(Long.valueOf(id));
        model.addAttribute("item", itemPersisted);
        return "uploadItemImageForm";
    }

    @PostMapping("/{id}/image")
    public String potImage(Model model, @PathVariable String id, @RequestParam("imagefile") MultipartFile file) {
        itemService.saveImage(Long.valueOf(id), file);

        model.addAttribute("item", itemService.findById(Long.valueOf(id)));
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "redirect:/items/update/{id}";
    }

    @GetMapping("/{id}/readimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        Item itemPersisted = itemService.findById(Long.valueOf(id));

        if (itemPersisted.getImage() != null) {
            byte[] byteArray = new byte[itemPersisted.getImage().length];
            int i = 0;

            for (Byte wrappedByte : itemPersisted.getImage()) {
                byteArray[i++] = wrappedByte;
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
