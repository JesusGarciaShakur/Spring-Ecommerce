package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String productName;
	private String description;
	private String image;
	private double price;
	private int quantity;
	
	@ManyToOne
	private User user;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String productName, String description, String image, double price, int quantity,
			User user) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", image="
				+ image + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
