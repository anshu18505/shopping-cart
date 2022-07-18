package com.shoppingcart.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "categoryy")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NotNull String categoryName;
    private @NotNull String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> products;


}
