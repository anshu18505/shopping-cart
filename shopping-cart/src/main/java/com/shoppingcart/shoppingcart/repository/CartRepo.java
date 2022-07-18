package com.shoppingcart.shoppingcart.repository;

import com.shoppingcart.shoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
}
