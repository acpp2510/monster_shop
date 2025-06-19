package com.api.monster_shop.dtos.review;

import jakarta.validation.constraints.*;

public record ReviewRequest(
    @NotNull(message = "Product ID is required")
    Long productId,

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be contain min 2 and max 50 characters")
    String username,

    @NotNull(message = " rating is required")
    @Max(value = 5, message = "Maximum rating is 5")
    @Min(value = 0, message = "Minimum rating is 0")
    Double rating,

    @NotBlank(message = "imageUrl is required")
    @Size(max = 255, message = "The review cannot exceed 255 characters")
    String body
) {
}
