package com.example.samplespringboot.services;

import com.example.samplespringboot.entities.ProductEntity;
import com.example.samplespringboot.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    private IProductRepository productRepository;
    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        // check valid id
        if(productEntity.getProductId() == null) {
            Optional<ProductEntity> productEntity1 = productRepository.findById(productEntity.getProductId());
            if (productEntity.isPresent()) {
                return productRepository.save(productEntity);
            }
        }

        return productRepository.save(productEntity);
    }

    public ProductEntity addProduct(ProductEntity productEntity) {
        productEntity.setProductId(null);
        return productRepository.save(productEntity);
    }

    //delete product by id
    public ProductEntity deleteProduct(int id) {
        // check valid id
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            productRepository.deleteById(id);
            return productEntity.getProductId();
        }else {
            throw new RuntimeException("Product not found");
        }

    }


}
