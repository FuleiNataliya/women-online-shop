package com.women.online.shop.controllers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

  private String name;
  private BigDecimal price;

}
