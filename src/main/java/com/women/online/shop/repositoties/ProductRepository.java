package com.women.online.shop.repositoties;

import com.women.online.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByCategories(String shortName);
}

