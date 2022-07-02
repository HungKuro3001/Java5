package com.example.samplespringboot.repositories;

import com.example.samplespringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {

}
