package com.shoppingcart.shoppingcart.dto;

import com.shoppingcart.shoppingcart.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Product product;
}
