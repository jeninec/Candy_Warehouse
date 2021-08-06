package com.revature.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Item;
import com.revature.models.Order;
import com.revature.repositories.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo or;
	
	@Override
	public Order addOrder(Order o) {
		return or.save(o);
	}

	@Override
	public Order getOrder(int id) {
		try {
			return or.findById(id).get();
		} catch (Exception e) {
			return new Order();
		}
		
	}

	@Override
	public List<Order> getAllOrders() {
		return (List<Order>) or.findAll();
	}

	@Override
	public Order updateOrder(Order change) {
		
		List<Item> pro = change.getItemId();
		
		double total = 0;
		
		if(pro != null) {
		       for (int i = 0; i < pro.size(); i++) {
		            
		    	    Item item = pro.get(i);
		            
		    	    int qty = item.getQtyOrdered();
		            
		            double price = item.getPrice();
		            
		            price *= qty;
		            
		            total += price;
		        }
		}
		
		change.setTotalPrice(total);
		
		return or.save(change);
	}

	@Override
	public boolean deleteOrder(int id) {
		try { 
			or.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
			
		}
	}

}
