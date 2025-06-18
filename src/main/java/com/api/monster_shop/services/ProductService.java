package com.api.monster_shop.services;

import com.api.monster_shop.dtos.product.ProductMapper;
import com.api.monster_shop.dtos.product.ProductRequest;
import com.api.monster_shop.dtos.product.ProductResponse;
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

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public Optional<Product> getProductById (Long id){
        return productRepository.findById(id);
    }

    public ProductResponse saveProduct (ProductRequest productRequest){
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    public Product updateProduct (Product product, ProductRequest newDetails){
        product.setName(newDetails.name());
        product.setPrice(newDetails.price());
        product.setImageUrl(newDetails.imageUrl());
        product.setRating(newDetails.rating());
        product.setReviewCount(newDetails.reviewCount());
        product.setFeatured(newDetails.featured());
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

}
