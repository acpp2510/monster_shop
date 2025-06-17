package com.api.monster_shop.services;

import com.api.monster_shop.models.Product;
import com.api.monster_shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct (Product newProduct){
        return productRepository.save(newProduct);
    }

}
