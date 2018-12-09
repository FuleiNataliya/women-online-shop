package com.women.online.shop.controllers;

import com.women.online.shop.controllers.dto.UserOrderDto;
import com.women.online.shop.entities.UserOrder;
import com.women.online.shop.repositoties.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserOrderController {
    private final UserOrderRepository userOrderRepository;
    public UserOrderController(@Autowired UserOrderRepository userOrderRepository) {
        this.userOrderRepository = userOrderRepository;
    }
    @PostMapping("/user_order")
    public void create(@RequestBody UserOrderDto userOrderDto){
        final UserOrder userOrder = new UserOrder(userOrderDto.getAmount(),userOrderDto.getCity());
        userOrderRepository.save(userOrder);
    }
    @GetMapping("/user_order/{id}")
    public ResponseEntity<Optional<UserOrder>> getById(@PathVariable String id) {
        final Optional<UserOrder> userOrder = userOrderRepository.findById(id);
        return ResponseEntity.ok(userOrder);
    }
    @GetMapping("/user_order")
    public ResponseEntity <List<UserOrder>> getAllUserOrder() {
       final List<UserOrder> userOrderList = userOrderRepository.findAll();
        return ResponseEntity.ok(userOrderList);
    }
    @DeleteMapping("/user_order/{id}")
    public void deleteUserOrder(@PathVariable String id){
        userOrderRepository.deleteById(id);
    }
}
