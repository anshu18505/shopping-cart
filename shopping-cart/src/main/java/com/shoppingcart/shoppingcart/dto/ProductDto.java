package com.shoppingcart.shoppingcart.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private @NotNull Integer id;
    private @NotNull String name;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull int quantity;
    private @NotNull int categoryId;
}
