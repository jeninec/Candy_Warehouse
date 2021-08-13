package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Item;
import com.revature.models.Order;
import com.revature.services.OrderService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
public class OrderControllerTests {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	OrderService os;
	
	@Test
	void getAllOrders() throws Exception {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(1, 5.20, "2020/05/21", "truck", false, null, iList);
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		
		Mockito.when(os.getAllOrders()).thenReturn(orderList);
		
		ResultActions ra = mvc.perform(get("/orders"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void getOrderById() throws Exception {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(1, 5.20, "2020/05/21", "truck", false, null, iList);
		
		Mockito.when(os.getOrder(1)).thenReturn(order);
		
		ResultActions ra = mvc.perform(get("/orders/1"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void addOrder() throws Exception {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(5.20, "2020/05/21", "truck", false, null, iList);
		
		Mockito.when(os.addOrder(order)).thenReturn(new Order(1, 5.20, "2020/05/21", "truck", false, null, iList));
	
		ResultActions ra = mvc.perform(post("/orders")
				  .content(asJsonString(order))
				  .contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void updateOrder() throws Exception {
		List<Item> iList = new ArrayList<Item>();
		Order order = new Order(1, 5.20, "2020/05/21", "truck", false, null, iList);
	
		Mockito.when(os.updateOrder(order)).thenReturn(new Order(1, 5.20, "2020/05/21", "car", false, null, iList));
	
		ResultActions ra = mvc.perform(put("/orders/1")
				  .content(asJsonString(order))
				  .contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void deleteItem() throws Exception {
		Mockito.when(os.deleteOrder(1)).thenReturn(true);
	
		
		ResultActions ra = mvc.perform(delete("/orders/1"));
		ra.andExpect(status().isOk());
	}
	
	
	//Helper method for request bodies
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
	
}
