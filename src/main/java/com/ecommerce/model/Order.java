package com.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private Date dateCreate;
	private Date dateRecibe;
	
	private double total;
	
	@ManyToOne
	private User user;
	
	@OneToOne(mappedBy = "order")
	private DetailOrder detail;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, String number, Date dateCreate, Date dateRecibe, double total) {
		super();
		this.id = id;
		this.number = number;
		this.dateCreate = dateCreate;
		this.dateRecibe = dateRecibe;
		this.total = total;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateRecibe() {
		return dateRecibe;
	}

	public void setDateRecibe(Date dateRecibe) {
		this.dateRecibe = dateRecibe;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public DetailOrder getDetail() {
		return detail;
	}

	public void setDetail(DetailOrder detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", dateCreate=" + dateCreate + ", dateRecibe=" + dateRecibe
				+ ", total=" + total + "]";
	}
	
	
}
