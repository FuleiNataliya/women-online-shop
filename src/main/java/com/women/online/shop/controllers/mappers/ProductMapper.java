package com.women.online.shop.controllers.mappers;

import com.women.online.shop.controllers.dto.ProductDto;
import com.women.online.shop.controllers.dto.ProductDtoWithId;
import com.women.online.shop.entities.Product;

public class ProductMapper{

    public static Product toProduct(ProductDto productDto) {
        return new Product(productDto.getName(), productDto.getPrice(),
                productDto.getCountry());
    }

    public static ProductDtoWithId toProductDto(Product product) {
        ProductDtoWithId productDtoWithId = new ProductDtoWithId();
        productDtoWithId.setId(product.getId());
        productDtoWithId.setCreatedAt(product.getCreatedAt());
        productDtoWithId.setName(product.getName());
        productDtoWithId.setPrice(product.getPrice());
        productDtoWithId.setCountry(product.getCountry());
        return productDtoWithId;

    }
}
