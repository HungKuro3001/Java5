package com.example.demodatabase.controller;

import com.example.demodatabase.entities.ProductEntity;
import com.example.demodatabase.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductRepository iproductRepository;
    @GetMapping("/get-all")
    public List<ProductEntity> getAll() {
        return iproductRepository.findAll();
    }
    @GetMapping("/add")
    public ProductEntity addProduct(ProductEntity product) {

        return iproductRepository.save(product);

    }
    @GetMapping("/get-by-name")
    public List<ProductEntity> findByName() {
        return iproductRepository.findByProductNameLike("%G");
    }
}
