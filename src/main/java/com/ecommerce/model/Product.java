package com.ecommerce.model;

public class Product {
	private Integer id;
	private String productName;
	private String description;
	private String image;
	private double price;
	private int quantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String productName, String description, String image, double price, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", image="
				+ image + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
