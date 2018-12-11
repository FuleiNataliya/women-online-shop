package com.women.online.shop.entities;
import lombok.*;

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
@ToString
@EqualsAndHashCode
@Table(name = "products")
public class Product extends AbstractEntity {
    @Column(name = "name")
    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Country country;
    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Set<Category> categories = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_user_orders"
    )
    private List<UserOrder> userOrders = new ArrayList<>();

    public Product(String name, BigDecimal price, Country country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }

    public void removeCategories(Category category) {
        if (categories.size() > 1) {
            categories.remove(category);
        }
    }
}
