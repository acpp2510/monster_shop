package com.api.monster_shop.dtos.review;

public record ReviewResponse(
        Long id,
        String username,
        Double rating,
        String body
) {
}
