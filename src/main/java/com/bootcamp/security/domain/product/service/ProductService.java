package com.bootcamp.security.domain.product.service;

import com.bootcamp.security.domain.product.dto.ProductCreateRequest;
import com.bootcamp.security.domain.product.dto.ProductResponse;
import com.bootcamp.security.domain.product.entity.Product;
import com.bootcamp.security.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::from)
                .toList();
    }

    @Transactional
    public void addProduct(ProductCreateRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .price(request.price())
                .quantity(request.quantity())
                .build();
        productRepository.save(product);
    }
}
