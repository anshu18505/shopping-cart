package com.shoppingcart.shoppingcart.repository;

import com.shoppingcart.shoppingcart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
