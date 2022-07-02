package com.example.samplespringboot2.services;

import com.example.samplespringboot2.entities.ProductEntity;
import com.example.samplespringboot2.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private IProductRepository productRepository;
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
    public ProductEntity updateProduct(ProductEntity productEntity) {
        Long id = productEntity.getId();
        if(id == null) {
            Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
            if(optionalProductEntity.isPresent()) {
                return productRepository.save(productEntity);
            }
        }
        return null;
    }
    public ProductEntity add(ProductEntity productEntity) {
        productEntity.setId(null);
        return productRepository.save(productEntity);
    }
    public ProductEntity deleteProduct(Long id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if(optionalProductEntity.isPresent()) {
            productRepository.deleteById(id);
            return optionalProductEntity.get();
        }
        return null;
    }
}
