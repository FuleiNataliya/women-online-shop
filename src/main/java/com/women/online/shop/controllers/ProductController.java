package com.women.online.shop.controllers;

import com.women.online.shop.controllers.dto.ProductDto;
import com.women.online.shop.controllers.dto.ProductDtoWithId;
import com.women.online.shop.controllers.mappers.ProductMapper;
import com.women.online.shop.entities.Product;
import com.women.online.shop.repositoties.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public ResponseEntity create(@RequestBody ProductDto productDto) {
        final Product product = ProductMapper.toProduct(productDto);
        productRepository.save(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDtoWithId>> getProducts() {
        final List<ProductDtoWithId> all = productRepository.findAll().
                stream().map(ProductMapper :: toProductDto).collect(Collectors.toList());
        return ResponseEntity.ok(all);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDtoWithId> findById(@PathVariable String id) {
        final Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductDtoWithId productDto = ProductMapper.toProductDto(product.get());
            return ResponseEntity.ok(productDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        final Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
