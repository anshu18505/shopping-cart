package com.shoppingcart.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NotNull  String name;
    private @NotNull  Double price;
    private @NotNull String description;
    private @NotNull int quantity;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Cart cart;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;


//    public Product(Integer id, String name, int quantity, Double price, String categoryName, Integer id1, String description) {
//        this.id=id;
//        this.name=name;
//        this.quantity=quantity;
//        this.price=price;
//        this.category.setCategoryName(categoryName);
//        this.category.setId(id1);
//        this.category.setDescription(description);
//    }

//    public void setCategory(Integer id1, String description1, String categoryName) {
//        this.category.setCategoryName(categoryName);
//        this.category.setId(id1);
//        this.category.setDescription(description1);
//    }
}
