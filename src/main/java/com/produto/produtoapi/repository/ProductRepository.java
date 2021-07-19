package com.produto.produtoapi.repository;

import com.produto.produtoapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
