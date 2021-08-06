package com.revature.services;

import java.util.List;

import com.revature.models.Order;


public interface OrderService {

	
	public Order addOrder(Order o);
	
	public Order getOrder(int id);
	
	public List<Order> getAllOrders();
	
	public Order updateOrder(Order change);
	
	public boolean deleteOrder(int id);

}
