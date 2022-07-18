package com.shoppingcart.shoppingcart.repository;

import com.shoppingcart.shoppingcart.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
}
