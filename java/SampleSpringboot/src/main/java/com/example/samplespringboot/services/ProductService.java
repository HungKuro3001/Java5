package com.example.samplespringboot.services;

import com.example.samplespringboot.entities.Product;
import com.example.samplespringboot.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product update(Product product){
        Long id = product.getId();
        if (id != null){
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()){
                return productRepository.save(product);
            }
        }
        return null;
    }

    public Product add(Product product){
        product.setId(null);
        return productRepository.save(product);
    }

    public Product delete(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.deleteById(id);
            return product.get();
        }
        return null;
    }




}
