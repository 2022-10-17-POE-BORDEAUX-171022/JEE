package com.jee.modele;

public class ProductBuilder {
	
	int id;
	String title;
	String desc;
	float price;
	
	
	public ProductBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	
	public ProductBuilder desc(String desc) {
		this.desc = desc;
		return this;
	}
	
	public ProductBuilder id(int id) {
		this.id = id;
		return this;
	}
	
	public ProductBuilder price(int price) {
		this.price = price;
		return this;
	}
	
	
	
	
	
	public MonProduct Builder() {
		return new MonProduct(this.id, this.title, this.desc, this.price);
	}
	
	
	
	
	
	class MonProduct{
		
		int id;
		String title;
		String desc;
		float price;
		
		public MonProduct(int id, String title, String desc, float price) {
			super();
			this.id = id;
			this.title = title;
			this.desc = desc;
			this.price = price;
		}		
	}
}
