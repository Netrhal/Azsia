package com.study.azsia.services;

import com.study.azsia.models.Product;
import com.study.azsia.repositories.ProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void save (Product product){
        productRepository.save(product);
    }
}
