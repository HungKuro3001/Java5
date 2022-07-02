package com.fpoly.demojpa2.controller;

import com.fpoly.demojpa2.entity.Product;
import com.fpoly.demojpa2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/get-all")
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    @GetMapping("/add")
    public Product addProduct(Product product) {
        product.setName("PS5");
         return productRepository.save(product);

    }
}
