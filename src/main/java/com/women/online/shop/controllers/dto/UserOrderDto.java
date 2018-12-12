package com.women.online.shop.controllers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@RestController
public class UserOrderDto {
    private List<String> productsIds;
    private String userId;
    private String city;
}
