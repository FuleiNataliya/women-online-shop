package com.women.online.shop.entities;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phones {
    private String mobilePhone;
    private String workingPhone;
    private String homePhone;
}