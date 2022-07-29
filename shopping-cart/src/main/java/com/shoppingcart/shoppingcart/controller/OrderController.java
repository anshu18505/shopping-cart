package com.shoppingcart.shoppingcart.controller;

import com.shoppingcart.shoppingcart.model.Order;
import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.repository.UserRepo;
import com.shoppingcart.shoppingcart.service.OrderService;
import com.shoppingcart.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String placeOrder(@RequestParam("userId") int userId) throws Exception {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new Exception("User id is invalid");
        }
        User user = optionalUser.get();
        orderService.placeOrder(user);
        return "Order placed successfully";
    }

    @GetMapping("/")
    public List<Order> getAllOrders(@RequestParam("userId") int userId) throws Exception {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new Exception("User id is invalid");
        }
        User user = optionalUser.get();
        List<Order> orderDtoList = orderService.listOrders(user);

        return orderDtoList;
    }
}