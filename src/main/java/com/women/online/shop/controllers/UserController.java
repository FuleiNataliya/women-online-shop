package com.women.online.shop.controllers;

import com.women.online.shop.controllers.dto.UserDto;
import com.women.online.shop.entities.Name;
import com.women.online.shop.entities.User;
import com.women.online.shop.repositoties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {

  private final UserRepository userRepository;

  public UserController(@Autowired UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/users")
  public void create(@RequestBody UserDto userDto) {
    final User user =
        new User(new Name(userDto.getFirstName(), null, userDto.getLastName()), userDto.getEmail());
    userRepository.save(user);
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUsers() {
    final List<User> all = userRepository.findAll();
    return ResponseEntity.ok(all);
  }

  // todo add Adress to user, User getByID, delete; Product, UserOrder;

  @PostConstruct
  public void postConstract() {
    System.out.println("PostConstruct");
  }
}
