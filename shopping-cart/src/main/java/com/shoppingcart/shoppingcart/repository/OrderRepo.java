package com.shoppingcart.shoppingcart.repository;

import com.shoppingcart.shoppingcart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
