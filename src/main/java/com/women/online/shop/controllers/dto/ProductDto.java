package com.women.online.shop.controllers.dto;

import com.women.online.shop.entities.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
=======
import java.math.BigDecimal;

>>>>>>> e8f95ec19d835dc00097be5153627715ecb1e4c1
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
<<<<<<< HEAD

    private String firstName;
    private String lastName;
    private Country country;
}
=======
    private String name;
    private BigDecimal price;
    private Country country;

}

>>>>>>> e8f95ec19d835dc00097be5153627715ecb1e4c1
