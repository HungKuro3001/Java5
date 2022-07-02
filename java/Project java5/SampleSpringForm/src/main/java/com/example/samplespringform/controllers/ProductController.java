package com.example.samplespringform.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ProductController {
    @GetMapping("/input")
    public String openProductInput() {
        return "product-input";
    }

    @PostMapping("/new-product")
    public String createNewProduct() {
        return "redirect:/products";
    }
}
