package com.revature.models;

import java.util.Arrays;
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
	@Column(name="total_price")
	private double totalPrice;
	@Column(name="date_ordered")
	private String dateOrdered;
	@Column(name="shiping_type")
	private String shippingType;
	@Column(name="shipped")
	private boolean shipped;
	@Column(name="qty_O")
	private int[] qtyO;
	
	@OneToMany
	@JoinColumn(name="itemid")
	private List<Item> itemId;

	public Order() {
		super();
	}

	public Order(int id, double totalPrice, String dateOrdered, String shippingType, boolean shipped, int[] qtyO,
			List<Item> itemId) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.dateOrdered = dateOrdered;
		this.shippingType = shippingType;
		this.shipped = shipped;
		this.qtyO = qtyO;
		this.itemId = itemId;
	}

	public Order(double totalPrice, String dateOrdered, String shippingType, boolean shipped, int[] qtyO,
			List<Item> itemId) {
		super();
		this.totalPrice = totalPrice;
		this.dateOrdered = dateOrdered;
		this.shippingType = shippingType;
		this.shipped = shipped;
		this.qtyO = qtyO;
		this.itemId = itemId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int[] getQtyO() {
		return qtyO;
	}

	public void setQtyO(int[] qtyO) {
		this.qtyO = qtyO;
	}

	public List<Item> getItemId() {
		return itemId;
	}

	public void setItemId(List<Item> itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", totalPrice=" + totalPrice + ", dateOrdered=" + dateOrdered + ", shippingType="
				+ shippingType + ", shipped=" + shipped + ", qtyO=" + Arrays.toString(qtyO) + ", itemId=" + itemId
				+ "]";
	}




}
