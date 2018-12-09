package com.women.online.shop.controllers;

import com.women.online.shop.controllers.dto.ProductDto;
import com.women.online.shop.entities.Name;
import com.women.online.shop.entities.Product;
import com.women.online.shop.repositoties.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public void create(@RequestBody ProductDto productDto) {
        final Product product = new Product;
        productRepository.save(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        final List<Product> all = productRepository.findAll();
        return ResponseEntity.ok(all);
    }

    // todo add Adress to user, User getByID, delete; Product, UserOrder;

    @PostConstruct
    public void postConstract() {
        System.out.println("PostConstruct");
    }
}