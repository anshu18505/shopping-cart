package com.shoppingcart.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date createdDate;

//    @ManyToMany
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    private int quantity;
}
