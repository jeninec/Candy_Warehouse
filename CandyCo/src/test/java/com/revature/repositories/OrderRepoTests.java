package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.revature.models.Order;



@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
@Transactional
public class OrderRepoTests {


	@Autowired
	public OrderRepo or;
	
	@Test
	@Rollback
	void addOrder() {
		Order order = new Order(20.00, "01/21/21", "USPS", false, null, null);
		Assertions.assertEquals(0, order.getId());
		
		order = or.save(order);
		System.out.println("order id" + order.getId());
		Assertions.assertNotEquals(0, order.getId());
				
	}
	
	@Test
	void getAllOrders() {
		List<Order> orders = (List<Order>) or.findAll();
		System.out.println(orders);
		Assertions.assertFalse(orders.isEmpty());
	}
	
	@Test
	void getOrder() {
		Optional<Order> order = or.findById(1);
		System.out.println(order);
		Assertions.assertFalse(order.isEmpty());
		
	}
	
	@Test
	void updateOrder() {
		Order order = or.findById(1).get();
		order.setShippingType("UPS");
		order.setShipped(true);
		or.save(order);
		Order order2 = or.findById(1).get();
		Assertions.assertEquals(order2, order);
	}
	
	@Test
	void deleteOrder() {		
		Optional<Order> order = or.findById(1);
		or.deleteById(1);
		Optional<Order> order2 = or.findById(1);
		System.out.println("this" + order);
		Assertions.assertNotEquals(order2, order);
		
	}
	

	
}
