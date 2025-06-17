package com.api.monster_shop.services;

import com.api.monster_shop.models.Product;
import com.api.monster_shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById (Long id){
        return productRepository.findById(id);
    }

    public Product saveProduct (Product newProduct){
        return productRepository.save(newProduct);
    }

    public Product updateProduct (Product product, Product newDetails){
        product.setName(newDetails.getName());
        product.setPrice(newDetails.getPrice());
        product.setImageUrl(newDetails.getImageUrl());
        product.setRating(newDetails.getRating());
        product.setReviewCount(newDetails.getReviewCount());
        product.setFeatured(newDetails.isFeatured());
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

}
