package com.example.samplespringboot.controllers;

import com.example.samplespringboot.entities.Product;
import com.example.samplespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("products",productService.getAll());
        return "/product-list";
    }

    @RequestMapping(value = "/add")
    public String add( ModelMap modelMap,Product product){
        if (productService.add(product) != null){
            modelMap.addAttribute("product",product);
            return "/product-detail";
        }else{
            return "/error";
        }
    }
}
