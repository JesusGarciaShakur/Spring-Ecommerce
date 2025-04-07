package com.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UploadFileService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private UploadFileService upload;

	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products/show";
	}

	@GetMapping("/create")
	public String create() {
		return "products/create";
	}

	@PostMapping("/save")
	public String save(Product product, @RequestParam("imageFile") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto de la vista {}", product);
		User u = new User(1, "", "", "", "", "", "", null);
		product.setUser(u);

		if (product.getId() == null) {
			String nameImage = upload.saveImage(file);
			product.setImage(nameImage);
		}

		productService.save(product);
		return "redirect:/products";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Product product = new Product();
		Optional<Product> optionalProduct = productService.get(id);
		product = optionalProduct.get();

		LOGGER.info("Este es el objeto de la busqueda {}", product);
		model.addAttribute("product", product);
		return "products/edit";
	}

	@PostMapping("/update")
	public String update(Product product, @RequestParam("imageFile") MultipartFile file) throws IOException {

		if (file.isEmpty()) { // when product is edit but the image dosn't change
			Product p = new Product();
			p = productService.get(product.getId()).get();
			product.setImage(p.getImage());
		} else { // when product change the image

			Product p = new Product();
			p = productService.get(product.getId()).get();

			// delete when isn't the image defect
			if (!p.getImage().equals("default.jpg")) {
				upload.deleteImage(p.getImage());
			}
			String nameImage = upload.saveImage(file);
			product.setImage(nameImage);
		}
		productService.update(product);
		return "redirect:/products";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {

		Product p = new Product();
		p = productService.get(id).get();

		// delete when isn't the image defect
		if (!p.getImage().equals("default.jpg")) {
			upload.deleteImage(p.getImage());
		}
		
		productService.delete(id);
		return "redirect:/products";
	}

}
