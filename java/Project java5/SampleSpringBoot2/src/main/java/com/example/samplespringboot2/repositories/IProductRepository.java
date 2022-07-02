package com.example.samplespringboot2.repositories;

import com.example.samplespringboot2.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {

}
