package com.demo3.demo3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Integer id;
    private String name;
    private String type;
    private double price;
    private int quantity;

//    public ItemDto(Integer id, String name, String type, double price, int quantity) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//        this.price = price;
//        this.quantity = quantity;
//    }
}
