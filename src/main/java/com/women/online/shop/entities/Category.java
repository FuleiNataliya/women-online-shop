package com.women.online.shop.entities;

import com.women.online.shop.exceptions.CategoryNotFoundException;

import java.util.Arrays;

public enum Category {
    FOOD_AND_BEVERAGE(1, "F&B"),
    HEALTHCARE(2, "HEALTH"),
    COMPUTING(3, "COMP"),
    TECHNIC(4, "TECH"),
    FRUITS(5, "FR"),
    VEGETABLES(6, "V"),
    CLOTHES(7, "CL");

    private final int number;
    private final String shortName;

    Category(int number, String shortName) {
        this.number = number;
        this.shortName = shortName;
    }

   public static Category getByNumber(int number) {
        return Arrays.stream(values())
                .filter(category -> category.number == number)
                .findFirst()
                .orElseThrow(() -> new CategoryNotFoundException("Category with number " + number + " not found"));
    }

    public static Category getByName(String name) {
        return Arrays.stream(values())
                .filter(category -> category.shortName.equals(name))
                .findFirst()
                .orElseThrow(() -> new CategoryNotFoundException("Category with shortName " + name + " not found"));
    }
}