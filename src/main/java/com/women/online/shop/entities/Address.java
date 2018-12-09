package com.women.online.shop.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Enumerated(EnumType.STRING)
    private Country country;
    private String city;
    private String street;
    private String homeNumber;
    private String apartment;
}
