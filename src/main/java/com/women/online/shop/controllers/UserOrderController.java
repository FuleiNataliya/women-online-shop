package com.women.online.shop.controllers;

import com.women.online.shop.controllers.dto.ProductDto;
import com.women.online.shop.controllers.dto.UserOrderDto;
import com.women.online.shop.entities.User;
import com.women.online.shop.entities.UserOrder;
import com.women.online.shop.repositoties.ProductRepository;
import com.women.online.shop.repositoties.UserOrderRepository;
import com.women.online.shop.repositoties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserOrderController {
    private final UserOrderRepository userOrderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    public UserOrderController(@Autowired UserOrderRepository userOrderRepository,UserRepository userRepository,
                               ProductRepository productRepository) {
        this.userOrderRepository = userOrderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    @PostMapping("/users/{userId}/orders")
    public ResponseEntity create(@RequestParam String userId, @RequestBody UserOrderDto userOrderDto, ProductDto productDto){
        Optional<User> userOptional = userRepository.findById(userId);
        System.out.print("ЮЗЕРРРРРРРРРРРРРРРРРРРР ІД"+userId);
        User user=userOptional.get();
        /*List<String> productsIds = userOrderDto.getProductsIds();
        List<Product> products =productRepository.findAllById(productsIds);*/
        UserOrder userOrder = new UserOrder(user, /*(Set<Product>) products,*/userOrderDto.getCity());
        userOrderRepository.save(userOrder);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/user_order/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        final Optional<UserOrder> userOrder = userOrderRepository.findById(id);
        if (userOrder.isPresent()) {
            return ResponseEntity.ok(userOrder);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user_order")
    public ResponseEntity<List<UserOrder>> getAllUserOrder() {
       final List<UserOrder> userOrderList = userOrderRepository.findAll();
        if (userOrderList != null) {
            return new ResponseEntity<List<UserOrder>>(userOrderList, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/user_order/{id}")
    public ResponseEntity deleteUserOrder(@PathVariable String id){
        if (userOrderRepository.findById(id) != null) {
            userOrderRepository.deleteById(id);
            return new ResponseEntity (HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
