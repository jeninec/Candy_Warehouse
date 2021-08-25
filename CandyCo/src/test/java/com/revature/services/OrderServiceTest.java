package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.repositories.OrderRepo;
import com.revature.models.Item;
import com.revature.models.Order;

@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
public class OrderServiceTest {

	@Autowired
	OrderService os;
	
	@MockBean
	OrderRepo or;
	
	@Test
	void addOrder() {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(15.20, "2020/05/21", "truck", false, null, iList);
		
		Mockito.when(or.save(order)).thenReturn(new Order(1, 15.20, "2020/05/21", "truck", false, null, iList));
	
		order = os.addOrder(order);
	
		Assertions.assertEquals(1, order.getId());
		Assertions.assertEquals(15.20, order.getTotalPrice());		
	}
	
	@Test
	void getOrder() {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(1, 5.20, "2020/05/21", "truck", false, null, iList);
		Optional<Order> optionO = Optional.of(order);
		
		Mockito.when(or.findById(order.getId())).thenReturn(optionO);
		
		Assertions.assertEquals(1, optionO.get().getId());
	}
	
	@Test
	void getAllOrders() {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(1, 5.20, "2020/05/21", "truck", false, null, iList);
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		
		
		Mockito.when(or.findAll()).thenReturn(orderList);
		
		orderList = os.getAllOrders();
		
		Assertions.assertNotNull(orderList);
	}
	
	@Test
	void updateOrder() {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(1, 5.20, "2020/05/21", "truck", false, null, iList);
		
		Mockito.when(or.save(order)).thenReturn(new Order(1, 15.20, "2020/05/21", "truck", false, null, iList));
		
		order = os.updateOrder(order);
		
		Assertions.assertEquals(15.20, order.getTotalPrice());
	}
	
	@Test
	void deleteItem() {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(5.20, "2020/05/21", "truck", false, null, iList);
		
		Mockito.doThrow(IllegalArgumentException.class).when(or).deleteById(order.getId());
		
		boolean ret = os.deleteOrder(order.getId());
		Assertions.assertFalse(ret);
	}
	
}
