package com.demo3.demo3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String type;
    private double price;
    private int quantity;

    public Item(String name, String type, double price, int quantity) {
//        this.id=id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
}
