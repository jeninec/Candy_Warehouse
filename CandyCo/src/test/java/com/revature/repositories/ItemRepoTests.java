package com.revature.repositories;

import java.util.List;

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
		Item cand = new Item("Double bubble", "bubble gum", 1.00, 1, "good gum", "/images/double-bubble.jpg", 0);
		Assertions.assertEquals(0, cand.getId());
		
		System.out.println(cand);
		System.out.println("candy id" + cand.getId());
		Assertions.assertNotEquals(0, cand.getId());
				
	}
}
