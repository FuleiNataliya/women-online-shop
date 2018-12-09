package com.women.online.shop.controllers.dto;

import com.women.online.shop.entities.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private String firstName;
    private String lastName;
    private Country country;
}
