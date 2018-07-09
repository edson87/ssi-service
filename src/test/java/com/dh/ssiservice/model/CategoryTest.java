package com.dh.ssiservice.model;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CategoryTest {
    private static final String EXPECTED_NAME = "EDSON";
    private static final String EXPECTED_CODE = "EPP";

    @Test
    public void testGetName() {
        Category category = new Category();

        category.setName(EXPECTED_NAME);
        assertEquals(category.getName(), "EDSON");
    }

    @Test
    public void testGetCode() {
        Category category = new Category();

        category.setName(EXPECTED_CODE);
        assertEquals(category.getName(),"EPP");
    }
}