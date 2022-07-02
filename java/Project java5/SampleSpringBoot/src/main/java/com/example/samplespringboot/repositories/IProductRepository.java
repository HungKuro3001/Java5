package com.example.samplespringboot.repositories;

import com.example.samplespringboot.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity,Integer> {


}
