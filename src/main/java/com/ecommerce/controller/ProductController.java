package com.ecommerce.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public String show() {
		return "products/show.html";
	}
	
	@GetMapping("/create")
	public String create() {
		return "products/create.html";
	}
	
	@PostMapping("/save")
	public String save(Product product) {
		LOGGER.info("Este es el objeto de la vista {}", product);
		User u = new User(1,"","","","","","", null);
		product.setUser(u);
		productService.save(product);
		return "redirect:/products";
	}
	
}
