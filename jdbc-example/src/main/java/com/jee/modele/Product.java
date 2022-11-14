package com.jee.modele;

public class Product {
	private int id;
	private String title;
	private String descr;
	private float price;
	
	public Product(int id, String title, String descr, float price) {
		this.id = id;
		this.title = title;
		this.descr = descr;
		this.price = price;
	}
	
	
	public Product(String title, String descr, float price) {
		this.title = title;
		this.descr = descr;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
