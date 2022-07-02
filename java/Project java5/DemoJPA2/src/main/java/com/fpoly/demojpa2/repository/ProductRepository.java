package com.fpoly.demojpa2.repository;

import com.fpoly.demojpa2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
