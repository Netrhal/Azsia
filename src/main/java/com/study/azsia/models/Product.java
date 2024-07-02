package com.study.azsia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "prodclass")
    private ProdClass prodClass;
    private String description;
    private Long price;


}

