package com.api.monster_shop.dtos.product;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be contain min 2 and max 50 characters")
        String name,

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be a positive value")
        @Digits(integer = 6, fraction = 2, message = "Invalid price format")
        Double price,

        @NotBlank(message = "imageUrl is required")
        @URL(message = "Image URL format is invalid")
        @Size(max = 255, message = "Image URL cannot exceed 255 characters")
        String imageUrl,

        @NotBlank(message = " rating is required")
        @Max(value = 5, message = "Maximum rating is 5")
        @Min(value = 0, message = "Minimum rating is 0")
        Double rating,

        @NotNull(message = "reviewCount is required")
        @PositiveOrZero(message = "Review counter cannot be negative")
        Integer reviewCount,

        @NotNull(message = "Must specify if product is featured (true or false)")
        Boolean featured
) {
}
