package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.revature.models.Item;

@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
@Transactional
public class ItemRepoTests {

	@Autowired
	public ItemRepo ir;
	
	@Test
	void getAllItems() {
		List<Item> items = (List<Item>) ir.findAll();
		System.out.println(items);
		Assertions.assertFalse(items.isEmpty());
	}
	
	@Test
	@Rollback
	void addItem() {
		Item cand = new Item("Double bubble", "bubble gum", 1.00, 1, "good gum", "/images/double-bubble.jpg");
		Assertions.assertEquals(0, cand.getId());
		
		cand = ir.save(cand);
		System.out.println("candy id" + cand.getId());
		Assertions.assertNotEquals(0, cand.getId());
				
	}
	
	@Test
	void getItem() {
		Optional<Item> item = ir.findById(1);
		System.out.println(item);
		Assertions.assertFalse(item.isEmpty());
		
	}
	
	@Test
	void updateItem() {
		Item item = ir.findById(1).get();
		item.setName("updated name");
		item.setPrice(3.00);
		ir.save(item);
		Item item2 = ir.findById(1).get();
		Assertions.assertEquals(item2, item);
	}
	
	@Test
	void deleteItem() {		
		Optional<Item> item = ir.findById(4);
		ir.deleteById(4);
		Optional<Item> item2 = ir.findById(4);
		System.out.println("this" + item);
		Assertions.assertNotEquals(item2, item);
		
	}
	
	@Test
	void getItemByName() {
		Item item = ir.findByName("twizzler");
		Assertions.assertEquals("twizzler", item.getName());
	}
	
}
