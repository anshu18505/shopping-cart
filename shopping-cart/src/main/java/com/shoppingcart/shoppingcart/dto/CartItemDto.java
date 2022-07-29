package com.shoppingcart.shoppingcart.dto;

import com.shoppingcart.shoppingcart.model.Cart;
import com.shoppingcart.shoppingcart.model.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartItemDto {
    private Integer id;
    private Integer total_quantity;
    private Product product;

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.total_quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
//        this.setProduct(cart.getProduct().getId(),cart.getProduct().getName(),cart.getProduct().getPrice(),cart.getProduct().getQuantity(),cart.getProduct().getDescription(),cart.getProduct().getCategory().getId(),cart.getProduct().getCategory().getDescription(),cart.getProduct().getCategory().getCategoryName());
    }

//    private void setProduct(Integer id, String name, Double price, int quantity, String description, Integer id1, String description1, String categoryName) {
//        this.product.setId(id);
//        this.product.setName(name);
//        this.product.setPrice(price);
//        this.product.setQuantity(quantity);
//        this.product.setDescription(description);
//        this.product.setCategory(id1,description1,categoryName);
//
//
//
//    }
}
