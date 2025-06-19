package com.api.monster_shop.dtos.review;

import com.api.monster_shop.dtos.review.ReviewRequest;
import com.api.monster_shop.dtos.review.ReviewResponse;
import com.api.monster_shop.models.Product;
import com.api.monster_shop.models.Review;


public class ReviewMapper {
    public static Review dtoToEntity (ReviewRequest dto, Product product) {
        return new Review(product, dto.username(), dto.rating(),dto.body());
    }

    public static ReviewResponse entityToDto (Review review) {
        return new ReviewResponse(review.getId(), review.getUsername(), review.getRating(), review.getBody());
    }
}


