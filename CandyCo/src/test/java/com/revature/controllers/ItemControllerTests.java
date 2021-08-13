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
import com.revature.services.ItemService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
public class ItemControllerTests {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	ItemService is;
	
	@Test
	void getAllItems() throws Exception {
		Item item = new Item("Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);
		
		Mockito.when(is.getAllItems()).thenReturn(itemList);
		
		ResultActions ra = mvc.perform(get("/items"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void getItemById() throws Exception {
		Item item = new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.when(is.getItem(1)).thenReturn(item);
		
		ResultActions ra = mvc.perform(get("/items/1"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void getItemBySearch() throws Exception {
		Item item = new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.when(is.getItem(1)).thenReturn(item);
		
		ResultActions ra = mvc.perform(get("/items/search")
				.param("name", "Bim"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void getItemByCategory() throws Exception {
		Item item = new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.when(is.getItem(1)).thenReturn(item);
		
		ResultActions ra = mvc.perform(get("/items/search-cat")
				.param("catagory", "hard candy"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void addItem() throws Exception {
		Item item = new Item("Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.when(is.addItem(item)).thenReturn(new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg"));
	
		ResultActions ra = mvc.perform(post("/items")
				  .content(asJsonString(item))
				  .contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void updateItem() throws Exception {
		Item item = new Item("Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.when(is.updateItem(item)).thenReturn(new Item(1, "BimUpdated", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg"));
	
		ResultActions ra = mvc.perform(put("/items/1")
				  .content(asJsonString(item))
				  .contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void deleteItem() throws Exception {
		Mockito.when(is.deleteItem(1)).thenReturn(true);
	
		
		ResultActions ra = mvc.perform(delete("/items/1"));
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
