package com.shoppingcart.shoppingcart.controller;

import com.shoppingcart.shoppingcart.dto.AddToCartDto;
import com.shoppingcart.shoppingcart.dto.CartDto;
import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.repository.UserRepo;
import com.shoppingcart.shoppingcart.service.CartService;
import com.shoppingcart.shoppingcart.service.ProductService;
import com.shoppingcart.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;


    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addToCart(@RequestBody AddToCartDto addToCartDto) throws Exception{
        Optional<User> optionalUser = userService.findById(addToCartDto.getUserId());
        if (optionalUser.isEmpty()) {
            return  "Invalid user id : " + addToCartDto.getUserId();
        }
        if (!productService.outOfStock(addToCartDto)) {
            return "This product is out of stock";
        }
        if (!productService.checkStockAvailability(addToCartDto)) {
            return "Only " + productService.getAvailableStock(addToCartDto) + " available in stock";
        }
        User user = optionalUser.get();
        return cartService.addToCart(addToCartDto, user);
    }
    @DeleteMapping("/delete/{cartItemId}")
    public String deleteCartItem(@PathVariable("cartItemId") int itemId,
                                                      @RequestParam("userId") int userId) throws Exception {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new Exception("User id is invalid");
        }
        User user = optionalUser.get();
        cartService.deleteCartItem(itemId, user);

        return "Item is deleted from cart";
    }
    @GetMapping("/getCartItem")
    public CartDto getCartItems(@RequestParam("userId") int userId) throws Exception {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new Exception("User id is invalid");
        }
        User user = optionalUser.get();
        CartDto cartDto = cartService.showCartItems(user);

        return cartDto;
    }


}
