package com.women.online.shop.controllers.dto;

import com.women.online.shop.entities.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private String name;
    private BigDecimal price;
    private Country country;
}