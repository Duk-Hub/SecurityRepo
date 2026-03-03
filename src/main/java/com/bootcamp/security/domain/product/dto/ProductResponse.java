package com.bootcamp.security.domain.product.dto;

import com.bootcamp.security.domain.product.entity.Product;

public record ProductResponse(
        String name,
        Long price,
        Long quantity
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getName(),product.getPrice(),product.getQuantity());
    }
}
