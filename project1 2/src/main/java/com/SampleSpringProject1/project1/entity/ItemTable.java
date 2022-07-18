package com.SampleSpringProject1.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ItemTable {

    @Id
    @GeneratedValue
    private Integer item_id;

    @Column(name = "item_name")
    private String item_name;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "product_type")
    private String product_type;

}
