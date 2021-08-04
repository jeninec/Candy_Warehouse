package com.revature.models;

public class Item {

	
	private int id;
	
	private String name;
	
	private String catagory;
	
	private double price;
	
	private int qty;
	
	private String description;
	
	private String imgSrc;

	public Item() {
		super();
	}

	public Item(int id, String name, String catagory, double price, int qty, String description, String imgSrc) {
		super();
		this.id = id;
		this.name = name;
		this.catagory = catagory;
		this.price = price;
		this.qty = qty;
		this.description = description;
		this.imgSrc = imgSrc;
	}

	public Item(String name, String catagory, double price, int qty, String description, String imgSrc) {
		super();
		this.name = name;
		this.catagory = catagory;
		this.price = price;
		this.qty = qty;
		this.description = description;
		this.imgSrc = imgSrc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", catagory=" + catagory + ", price=" + price + ", qty=" + qty
				+ ", description=" + description + ", imgSrc=" + imgSrc + "]";
	}
	
	
	
	
}
