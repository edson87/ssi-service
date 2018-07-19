package com.dh.ssiservice.controller;

import com.dh.ssiservice.model.Category;
import com.dh.ssiservice.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

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

    /*@GET
    public Response getCategories(@QueryParam("code") String code) {
        List<Category> categories = categoryService.findByCode(code);
        Response.ResponseBuilder responseBuilder = Response.ok(categories);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    public Response getCategoriesById(@PathParam("id") @NotNull Long id) {
        Category category = categoryService.findById(id);
        Response.ResponseBuilder responseBuilder = Response.ok(category);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    private void addCorsHeader(Response.ResponseBuilder responseBuilder) {
        responseBuilder.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .header("Access-Control-Allow-Headers",
                        "Access-Control-Allow-Credentials, Access-Control-Allow-Headers, Origin, Accept, Authorization, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }*/
}
