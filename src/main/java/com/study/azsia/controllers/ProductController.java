package com.study.azsia.controllers;


import com.study.azsia.models.ProdClass;
import com.study.azsia.models.Product;
import com.study.azsia.requests.ProductRequest;
import com.study.azsia.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(value = "products/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest product){
        if (product.getName() == null || product.getName().isEmpty()){
            return ResponseEntity.badRequest().body("Name is required");
        }
        if (product.getPrice() == null){
            return ResponseEntity.badRequest().body("Price is required");
        }
        if (!isValidProductType(product.getProdClass())){
            return ResponseEntity.badRequest().body("Invalid product class");
        }

        Product savedProduct = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .prodClass(ProdClass.valueOf(product.getProdClass()))
                .build();

        productService.save(savedProduct);

        return ResponseEntity.ok(200);
    }

    private boolean isValidProductType(String prodClassString) {
        for (ProdClass prodClass : ProdClass.values()) {
            if(prodClass.name().equalsIgnoreCase(prodClassString)){
                return true;
            }
        }
        return false;
    }
}