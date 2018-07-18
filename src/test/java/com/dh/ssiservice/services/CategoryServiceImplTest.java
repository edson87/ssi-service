package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Category;
import com.dh.ssiservice.repository.CategoryRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class CategoryServiceImplTest {
    private static final String OTRA_CAT = "OTRACAT";

    private List<Category> categorySet;


    @Mock
    CategoryRepository categoryRepository;
    @InjectMocks
    CategoryServiceImpl categoryServiceImpl;

    /*@BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categorySet = new ArrayList<>();
        Category category = new Category();
        category.setName(OTRA_CAT);
        categorySet.add(category);
        when(categoryRepository.findAll()).thenReturn(categorySet);
        verify(categoryRepository,times(1)).findAll();
    }*/

    @Test
    public void testGetCategory() {
        /*List<Category> result = categoryServiceImpl.getCategory();
//        verify(categoryRepository,times(1)).findAll();
        verify(categoryRepository).findAll();
        assertEquals(result, categorySet);
        assertEquals(result.get(0).getName(), OTRA_CAT);*/
    }

    @Test
    public void testFindByCode() {
        when(categoryRepository.findByCode(any())).thenReturn(null);

        List<Category> result = categoryServiceImpl.findByCode("code");
        assertEquals(result, Arrays.<Category>asList(new Category()));
    }

    @Test
    public void testFindById() {
       // Optional<Category> result = categoryServiceImpl.findById(Long.valueOf(1));
       // Assert.assertEquals(result, null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme