package com.shoppingcart.shoppingcart.service;

import com.shoppingcart.shoppingcart.dto.AddToCartDto;
import com.shoppingcart.shoppingcart.dto.CartDto;
import com.shoppingcart.shoppingcart.dto.CartItemDto;
import com.shoppingcart.shoppingcart.model.Cart;
import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.repository.CartRepo;
import com.shoppingcart.shoppingcart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    ProductService productService;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductRepo productRepo;
    public String addToCart(AddToCartDto addToCartDto, User user) throws Exception
    {
        Product product=productService.findById(addToCartDto.getProductId());
        Cart cart=new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setCreatedDate(new Date());
        cart.setQuantity(addToCartDto.getQuantity());

        cartRepo.save(cart);
        if(product.getQuantity()- addToCartDto.getQuantity()<0)
            throw new Exception("Product Quantity is not available");
        product.setQuantity(product.getQuantity()- addToCartDto.getQuantity());
        productRepo.save(product);
        return "item added in cart";
    }
    public void deleteCartItem(int cartItemId, User user) throws Exception {
        Optional<Cart> optionalCart = cartRepo.findById(cartItemId);
        if (optionalCart.isEmpty()) {
            throw new Exception("Cart item is invalid : " + cartItemId);
        }
        Cart cart = optionalCart.get();
        if (cart.getUser() != user) {
            throw new Exception("Cart item does not belong to user: " + user.getId());
        }
        Product product=productService.findById(cart.getProduct().getId());

        product.setQuantity(product.getQuantity() + cart.getQuantity());
        cartRepo.delete(cart);
        productRepo.save(product);


    }
    public CartDto showCartItems(User user) {
        List<Cart> cartList = cartRepo.findAllByUser(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart : cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
//            Product product=new Product(cart.getProduct().getId(),cart.getProduct().getName(),cart.getProduct().getQuantity(),cart.getProduct().getPrice(),cart.getProduct().getCategory().getCategoryName(), cart.getProduct().getCategory().getId(),cart.getProduct().getCategory().getDescription());
//            cartItemDto.setProduct(cart.getProduct());
//            cartItemDto.setTotal_quantity(cart.getQuantity());
            cartItems.add(cartItemDto);
        }
        CartDto cartDto = new CartDto(cartItems,totalCost);
//        cartDto.setTotalCost(totalCost);
//        cartDto.setCartItems(cartItems);

        return cartDto;
    }



    public void deleteUserCart(User user) {
        cartRepo.deleteByUser(user);
    }
}
