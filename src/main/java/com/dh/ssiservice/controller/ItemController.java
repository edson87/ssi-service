package com.dh.ssiservice.controller;

import com.dh.ssiservice.dao.ItemCommand;
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
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/items")
@Produces("application/json")
@CrossOrigin
public class ItemController {
    //private ItemRepository itemRepository;
    private ItemService itemService;
    private SubCategoryService subCategoryService;

    public ItemController(ItemService itemService, SubCategoryService subCategoryService) {
        this.itemService = itemService;
        this.subCategoryService = subCategoryService;
    }


    /*@RequestMapping
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
    }*/

    @GET
    public Response getItems() {
        List<ItemCommand> items = new ArrayList<>();
        itemService.findAll().forEach(item -> {
            ItemCommand itemCommand = new ItemCommand(item);
            items.add(itemCommand);
        });
        Response.ResponseBuilder responseBuilder = Response.ok(items);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    public Response getItemId(@PathParam("id") @NotNull Long id) {
        Item item = itemService.findById(id);
        Response.ResponseBuilder responseBuilder = Response.ok(item);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @POST
    public Response saveItem(ItemCommand item){
        Item model = item.toDomain();
        model.setSubCategory(subCategoryService.findById(item.getSubCategoryId()));
        Item itemPersisted = itemService.save(model);
        Response.ResponseBuilder responseBuilder = Response.ok(itemPersisted);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @PUT
    public Response updateItem(Item item){
        Item itemPersisted = itemService.save(item);
        Response.ResponseBuilder responseBuilder = Response.ok(itemPersisted);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteItem(@PathParam("id") String id){
        itemService.deleteById(Long.valueOf(id));
        Response.ResponseBuilder responseBuilder = Response.ok();
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }



    private void addCorsHeader(Response.ResponseBuilder responseBuilder) {
        responseBuilder.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .header("Access-Control-Allow-Headers",
                        "Access-Control-Allow-Credentials, Access-Control-Allow-Headers, Origin, Accept, Authorization, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }
}
