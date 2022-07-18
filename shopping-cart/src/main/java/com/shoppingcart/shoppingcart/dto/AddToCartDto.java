package com.shoppingcart.shoppingcart.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer userId;
    private @NotNull Integer quantity;
}
