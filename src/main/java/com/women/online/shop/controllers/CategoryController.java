package com.women.online.shop.controllers;

import com.women.online.shop.entities.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CategoryController {
    List<Category> categoryList = new ArrayList<>();

    @GetMapping("/categories")
    public Set<Category> getCategories() {
        Category[] values = Category.values();
        Set<Category> categories = new HashSet<>(Arrays.asList(values));
        return categories;
    }

}
