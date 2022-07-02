package com.demo.sampleSpringForm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.sampleSpringForm.models.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@GetMapping("")
	public String openProductInput() {
		return "product-input";
	}
	@PostMapping ("/add")
	public  String add(Model model,Product p){
		model.addAttribute("p", p);
		return "product-detail";
	}
}
