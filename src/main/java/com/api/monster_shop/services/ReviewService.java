package com.api.monster_shop.services;

import com.api.monster_shop.dtos.review.ReviewMapper;
import com.api.monster_shop.dtos.review.ReviewRequest;
import com.api.monster_shop.dtos.review.ReviewResponse;
import com.api.monster_shop.models.Product;
import com.api.monster_shop.models.Review;
import com.api.monster_shop.repositories.ProductRepository;
import com.api.monster_shop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product not found with id: " + productId);
        }

        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }

    public ReviewResponse saveReview(ReviewRequest reviewRequest) {
        Product product = productRepository.findById(reviewRequest.productId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + reviewRequest.productId()));

        Review savedReview = reviewRepository.save(ReviewMapper.dtoToEntity(reviewRequest, product));
        return ReviewMapper.entityToDto(savedReview);
    }

}
