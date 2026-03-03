package com.bootcamp.security.domain.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductCreateRequest(
        @NotBlank
        String name,
        @NotNull @Size(min = 1)
        Long price,
        @NotNull @Size(min = 1)
        Long quantity
) {
}
