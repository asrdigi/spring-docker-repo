package com.adp.spring.model;



public class Product {
	private Integer id;
	private String brand;
	private String name;
	private Integer quantity;
	private Double price;
	
	public Product() {
		
	}

	

	public Product(Integer id, String brand, String name, Integer quantity, Double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	

}
