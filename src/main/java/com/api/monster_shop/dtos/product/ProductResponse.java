package com.api.monster_shop.dtos.product;

public record ProductResponse (
     Long id,
     String name,
     Double price,
     String imageUrl,
     Double rating,
     Integer reviewCount,
     Boolean featured
){}