package com.api.monster_shop.dtos;

import com.api.monster_shop.dtos.product.ProductRequest;
import com.api.monster_shop.dtos.product.ProductResponse;
import com.api.monster_shop.models.Product;

public class ProductMapper {
    public static Product dtoToEntity (ProductRequest dto) {
        return new Product(dto.name(), dto.price(),dto.imageUrl(), dto.rating(), dto.reviewCount(), dto.featured());
    }

    public static ProductResponse entityToDto (Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(),product.getImageUrl(), product.getRating(), product.getReviewCount(), product.isFeatured());
    }
}
