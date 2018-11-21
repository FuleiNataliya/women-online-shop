package com.women.online.shop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product extends AbstractEntity {
    @Column(name = "name")
    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Country country;
    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    private Set<Category> categories = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_customs")
    private List<UserOrder> userOrders = new ArrayList<>();

    public Product(String name, BigDecimal price, Country country, Set<Category> categories) {
        this.setName(name);
        this.setPrice(price);
        this.setCountry(country);
        this.categories.addAll(categories);
    }

    public void removeCategories(Category category) {
        if (categories.size() > 1) {
            categories.remove(category);
        }
    }
}


