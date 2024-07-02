package com.study.azsia.services;

import com.study.azsia.repositories.ProductRepository;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductService {

    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
}
