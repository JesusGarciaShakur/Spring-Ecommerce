package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String userName;
	private String email;
	private String numberPhone;
	private String type;
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Product> products;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	public User() {
		
	}
	
	public User(Integer id, String name, String userName, String email, String numberPhone, String type,
			String password, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.numberPhone = numberPhone;
		this.type = type;
		this.password = password;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", email=" + email + ", numberPhone="
				+ numberPhone + ", type=" + type + ", password=" + password + "]";
	}
	
}
