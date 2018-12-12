package com.women.online.shop.controllers.dto;

import com.women.online.shop.entities.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ProductDtoWithId {
    private String id;
    private LocalDateTime createdAt;
    private String name;
    private BigDecimal price;
    private Country country;
}

