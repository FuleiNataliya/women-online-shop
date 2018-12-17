package com.women.online.shop.repositoties;

import com.women.online.shop.entities.Address;
import com.women.online.shop.entities.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUserByAddressIsNotNull(Address address);
}





