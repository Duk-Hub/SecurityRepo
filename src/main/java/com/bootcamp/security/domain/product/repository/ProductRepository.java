package com.bootcamp.security.domain.product.repository;

import com.bootcamp.security.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
