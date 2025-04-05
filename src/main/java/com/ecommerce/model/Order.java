package com.ecommerce.model;

import java.util.Date;

public class Order {

	private Integer id;
	private String number;
	private Date dateCreate;
	private Date dateRecibe;
	
	private double total;
	
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", dateCreate=" + dateCreate + ", dateRecibe=" + dateRecibe
				+ ", total=" + total + "]";
	}
	
	
}
