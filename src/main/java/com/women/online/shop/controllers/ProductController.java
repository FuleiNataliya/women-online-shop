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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // final List<Product> allProducts = productRepository.findAll();
        List<ProductDtoWithId> all = new ArrayList<>();
       // allProducts.stream().map(ProductMapper :: toProductDto).forEach(productDtoWithId -> all.add(productDtoWithId));
        productRepository.findAll().stream().map(ProductMapper :: toProductDto).forEach(all :: add);
//        List<ProductDtoWithId> all = new ArrayList<>();
//        for (Product product : allProducts) {
//            ProductDtoWithId productDto = ProductMapper.toProductDto(product);
//            all.add(productDto);
//        }
        return ResponseEntity.ok(all);
    }

    /*
    public ResponseEntity<User> getUser(@PathVariable Long id) {
    return Optional
            .ofNullable( userRepository.findOne(id) )
            .map( user -> ResponseEntity.ok().body(user) )          //200 OK
            .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found
}
     */



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
