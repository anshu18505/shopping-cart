package com.shoppingcart.shoppingcart.repository;

import com.shoppingcart.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
//    List<Product> findByCategoryId(int category_id);
}
