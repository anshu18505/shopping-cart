package com.shoppingcart.shoppingcart.service;

import com.shoppingcart.shoppingcart.dto.CartDto;
import com.shoppingcart.shoppingcart.dto.CartItemDto;
import com.shoppingcart.shoppingcart.model.Order;
import com.shoppingcart.shoppingcart.model.OrderItem;
import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.repository.OrderItemRepo;
import com.shoppingcart.shoppingcart.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderItemRepo orderItemRepo;
    @Autowired
    private CartService cartService;

    @Transactional
    public void placeOrder(User user) throws Exception {
        CartDto cartDto = cartService.showCartItems(user);
        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();
        if (cartDto.getTotalCost() == 0) {
            throw new Exception("Cart is empty");
        }
        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        newOrder.setUser(user);
        newOrder.setTotalPrice(cartDto.getTotalCost());
        orderRepo.save(newOrder);
        for (CartItemDto cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCreatedDate(new Date());
            orderItem.setPrice(cartItemDto.getProduct().getPrice());
            orderItem.setProduct(cartItemDto.getProduct());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setOrder(newOrder);
            orderItemRepo.save(orderItem);
        }
        cartService.deleteUserCart(user);

    }

    public List<Order> listOrders(User user) {
        return orderRepo.findAllByUser(user);
    }
}
