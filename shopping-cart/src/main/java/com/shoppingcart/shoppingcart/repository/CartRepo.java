package com.shoppingcart.shoppingcart.repository;

import com.shoppingcart.shoppingcart.model.Cart;
import com.shoppingcart.shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUser(User user);

    void deleteByUser(User user);
}
