
package com.women.online.shop.controllers;

import com.women.online.shop.controllers.dto.ProductDto;
import com.women.online.shop.entities.Product;
import com.women.online.shop.repositoties.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public void create(@RequestBody ProductDto productDto) {
        final Product product = new Product(productDto.getName(), productDto.getPrice(),
                productDto.getCountry());
        productRepository.save(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        final List<Product> all = productRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable String id) {
        final Optional<Product> product = productRepository.findById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable String id) {
        productRepository.deleteById(id);
    }
}
