package com.shoppingcart.shoppingcart.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private List<CartItemDto> cartItems;
    private double totalCost;
}
