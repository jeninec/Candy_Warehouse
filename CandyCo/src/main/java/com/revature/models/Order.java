package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="qty_ordered")
	private int qtyOrdered;
	@Column(name="total_price")
	private double totalPrice;
	@Column(name="date_ordered")
	private String dateOrdered;
	@Column(name="shiping_type")
	private String shippingType;
	@Column(name="shipped")
	private boolean shipped;
	
	@OneToMany
	@JoinColumn(name="itemid")
	private List<Item> itemId;

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
