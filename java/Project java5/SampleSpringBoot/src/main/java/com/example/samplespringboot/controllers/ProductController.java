package com.example.samplespringboot.controllers;

import com.example.samplespringboot.entities.ProductEntity;
import com.example.samplespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("")
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("product",productService.getAllProducts());
        return "/index";
    }

    @RequestMapping("/add")
    public String add(ModelMap modelMap,ProductEntity product){
        if(productService.addProduct(product) != null){
            modelMap.addAttribute("product",product);
            return "/product-detail";
        }else {
            return "/error";
        }
    }




}
