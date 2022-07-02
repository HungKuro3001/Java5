package edu.poly.sj5.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.sj5.model.Product;
import edu.poly.sj5.repository.IProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductRepository productRepository;
	
	@GetMapping
	public String getAll(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "product/list";
	}
	
}
