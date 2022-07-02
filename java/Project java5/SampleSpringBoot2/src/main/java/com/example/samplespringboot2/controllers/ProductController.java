package com.example.samplespringboot2.controllers;

import com.example.samplespringboot2.entities.ProductEntity;
import com.example.samplespringboot2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value ="/")
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("products", productService.getAllProducts());
        return "/product-list";
    }

    @RequestMapping(value ="/add")
    public String addProduct(ModelMap modelMap, ProductEntity productEntity){
        if(productService.add(productEntity)!=null){
            modelMap.addAttribute("product",productEntity);
            return "/product-detail";
        }else{
            return "/error";
        }
    }


}
