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

import com.revature.repositories.ItemRepo;
import com.revature.models.Item;

@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
public class ItemServiceTest {

	@Autowired
	ItemService is;

	@MockBean
	ItemRepo ir;
	
	@Test
	void addItem() {
		Item item = new Item("Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.when(ir.save(item)).thenReturn(new Item(1, item.getName(), item.getCatagory(), item.getPrice(),
				item.getQty(), item.getDescription(), item.getImgSrc()));
		
		item = is.addItem(item);
		
		Assertions.assertEquals(1, item.getId());
		Assertions.assertEquals("Bim", item.getName());
	}
	
	@Test
	void getItem() {
		Item item = new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		Optional<Item> optionI = Optional.of(item);
		
		Mockito.when(ir.findById(item.getId())).thenReturn(optionI);
			
		Assertions.assertEquals(1, optionI.get().getId());
	}
	
	@Test
	void getItemByName() {
		Item item = new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.when(ir.findByName(item.getName())).thenReturn(item);
			
		Assertions.assertEquals(1, item.getId());
		Assertions.assertEquals("Bim", item.getName());
	}
	
	@Test
	void getAllItems() {
		Item item = new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(ir.findAll()).thenReturn(items);
		
		items = is.getAllItems();
		
		Assertions.assertNotNull(items);
	}
	
	@Test
	void updateItem() {
		Item item = new Item(1, "Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		Mockito.when(ir.save(item)).thenReturn(new Item(1, "BimUpdated", "hard candy", 1.50, 50,
				"Bim bam bop my brotha", "../../../assets/images/test.jpeg"));
		
		item = is.updateItem(item);
		Assertions.assertEquals(1, item.getId());
		Assertions.assertEquals("BimUpdated", item.getName());
	}
	
	@Test
	void deleteItem() {
		Item item = new Item("Bim", "hard candy", 1.50, 50,  "Bim bam bop my brotha", "../../../assets/images/test.jpeg");
		
		Mockito.doThrow(IllegalArgumentException.class).when(ir).deleteById(item.getId());
		
		boolean ret = is.deleteItem(item.getId());
		Assertions.assertFalse(ret);
	}
	
	
}
