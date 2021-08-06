package com.revature.models;

public class Order {

	private int id;
	
	private int qtyOrdered;
	
	private double totalPrice;
	
	private String dateOrdered;
	
	private String shippingType;
	
	private boolean shipped;

	public Order() {
		super();
	}

	public Order(int id, int qtyOrdered, double totalPrice, String dateOrdered, String shippingType, boolean shipped) {
		super();
		this.id = id;
		this.qtyOrdered = qtyOrdered;
		this.totalPrice = totalPrice;
		this.dateOrdered = dateOrdered;
		this.shippingType = shippingType;
		this.shipped = shipped;
	}

	public Order(int qtyOrdered, double totalPrice, String dateOrdered, String shippingType, boolean shipped) {
		super();
		this.qtyOrdered = qtyOrdered;
		this.totalPrice = totalPrice;
		this.dateOrdered = dateOrdered;
		this.shippingType = shippingType;
		this.shipped = shipped;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", qtyOrdered=" + qtyOrdered + ", totalPrice=" + totalPrice + ", dateOrdered="
				+ dateOrdered + ", shippingType=" + shippingType + ", shipped=" + shipped + "]";
	}


	
	
}
