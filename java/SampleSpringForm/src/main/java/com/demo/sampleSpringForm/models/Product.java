package com.demo.sampleSpringForm.models;

import java.math.BigDecimal;

public class Product {
	private String name;
	private BigDecimal price;
	private Integer quantity;
	public String getName() {
		return name;
	}
	
	public Product() {
		super();
	}

	public Product(String name, BigDecimal price, Integer quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
