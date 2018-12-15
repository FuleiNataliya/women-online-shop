package com.women.online.shop.controllers.mappers;

import com.women.online.shop.controllers.dto.UserDto;
import com.women.online.shop.entities.Address;
import com.women.online.shop.entities.Name;
import com.women.online.shop.entities.User;

public class UserMapper {
    public static UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getName().getFirstName());
        userDto.setLastName(user.getName().getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setCountry(user.getAddress().getCountry());
        userDto.setCity(user.getAddress().getCity());
        userDto.setStreet(user.getAddress().getStreet());
        userDto.setHomeNumber(user.getAddress().getHomeNumber());
        userDto.setApartment(user.getAddress().getApartment());
        return userDto;
    }

    public static User convertToEntity(UserDto userDto) {
        User user = new User();
        Name name = new Name();
        name.setFirstName(userDto.getFirstName());
        name.setMiddleName(null);
        name.setLastName(userDto.getLastName());
        Address address = new Address();
        address.setCountry(userDto.getCountry());
        address.setCity(userDto.getCity());
        address.setStreet(userDto.getStreet());
        address.setHomeNumber(userDto.getHomeNumber());
        address.setApartment(userDto.getApartment());
        user.setName(name);
        user.setEmail(userDto.getEmail());
        user.setAddress(address);
        return user;
    }
}
