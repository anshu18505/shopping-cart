package com.paytm.LOS.shoppingcartLOS.repository;


import com.paytm.LOS.shoppingcartLOS.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
