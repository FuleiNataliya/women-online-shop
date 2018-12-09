package com.women.online.shop.entities;

import com.women.online.shop.exceptions.CategoryNotFoundException;
import org.junit.Assert;
import org.junit.Test;


public class CategoryTest {
    @Test
    public void getByNumberShouldReturnFruits() {
        final Category category = Category.FRUITS;
        final Category number = Category.getByNumber(5);
        Assert.assertEquals(category, number);
    }

    @Test
    public void getByNameShouldReturnFruits() {
        final Category category = Category.FRUITS;
        final Category name = Category.getByName("FR");
        Assert.assertEquals(category, name);
    }

    @Test(expected = CategoryNotFoundException.class)
    public void getByNameShouldReturnCategoryNotFoundException() {
        Category.getByName("pink");
    }

    @Test(expected = CategoryNotFoundException.class)
    public void getByNumberShouldReturnCategoryNotFoundException() {
        Category.getByNumber(111);
    }
}