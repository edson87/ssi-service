package com.dh.ssiservice.controller;

import com.dh.ssiservice.model.Category;
import com.dh.ssiservice.services.CategoryService;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;

public class CategoryControllerTest {
    @Mock
    CategoryService categoryService;

    @Mock
    Model model;

    @InjectMocks
    CategoryController categoryController;
    private ArrayList<Category> categoryList;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCategories() {
       /* ArgumentCaptor<List<Category>> argumentCaptor= ArgumentCaptor.forClass((Class<List<Category>>)categoryList.getClass());
        String result = categoryController.getCategories(null, model);
        String expectedView = "categories";
        assertEquals(expectedView, result);
        assertEquals(expectedView, expectedView);
        verify(categoryService,times(1)).getCategory();
        verify(model,times(1)).addAttribute(eq(expectedView), eq(categoryList));

        verify(model,times(1)).addAttribute(eq("categories"), argumentCaptor.capture());
        List<Category> capturedCategories = argumentCaptor.getValue();
        assertEquals(capturedCategories.size(),1);*/

    }

    @Test
    public void testGetCategoriesById() {
        when(categoryService.findById(anyLong())).thenReturn(null);

        String result = categoryController.getCategoriesById(Long.valueOf(1), null);
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme