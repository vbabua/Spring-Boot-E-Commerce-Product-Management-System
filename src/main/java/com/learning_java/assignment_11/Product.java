package com.learning_java.assignment_11;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
     Integer id;
    @Column(name="name")
    private String name;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="category_id")
    private Integer categoryId;

}
