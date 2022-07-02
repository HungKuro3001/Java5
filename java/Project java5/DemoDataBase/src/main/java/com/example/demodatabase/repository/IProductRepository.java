package com.example.demodatabase.repository;

import com.example.demodatabase.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByProductNameLike(String productName);
}
