package com.women.online.shop.controllers.dto;

import com.women.online.shop.entities.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private Country country;
    private String city;
    private String street;
    private String homeNumber;
    private String apartment;
}
