package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Order;
import com.revature.services.OrderService;



@RestController
public class OrderController {

	
	@Autowired
	OrderService os;
	
	@GetMapping(value = "/orders", produces = "application/json")
	public List<Order> getAllOrders(){
		return os.getAllOrders();
	}
	
	@GetMapping("orders/{id}")
	public Order getItem(@PathVariable("id") String id) {
		return os.getOrder(Integer.parseInt(id));
		
	}
	
	@PostMapping(value = "/orders", consumes = "application/json", produces = "application/json")
	public Order addOrder(@RequestBody Order o) {
		return os.addOrder(o);
	}
	
	@PutMapping(value = "/orders/{id}", consumes = "application/json", produces = "application/json")
	public Order updateOrder(@PathVariable int id, @RequestBody Order change) {
		change.setId(id);
		return os.updateOrder(change);
	}
	
	@DeleteMapping("/orders/{id}")
	public boolean deleteItem(@PathVariable int id) {
		return os.deleteOrder(id);
	}
}
