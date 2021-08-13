package com.revature.app;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.revature.models.Item;
import com.revature.models.Order;
import com.revature.models.Person;
import com.revature.repositories.ItemRepo;
import com.revature.repositories.OrderRepo;
import com.revature.repositories.PersonRepo;

@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
@Transactional
public class AllTests {

	@Autowired
	public ItemRepo ir;
	
	@Autowired
	public OrderRepo or;
	
	@Autowired
	public PersonRepo pr;
	
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
	
	@Test
	void getAllPersons() {
		List<Person> person = (List<Person>) pr.findAll();
		System.out.println(person);
		Assertions.assertFalse(person.isEmpty());
	}
	
	@Test
	@Rollback
	void addPerson() {
		Person person = new Person("Maybal", "Carter", "pass", "mcarter@gmail.com", "1194 Myra St", null, "Providence", "RI", "02905", "401-455-3725", "buyer", null);
		Assertions.assertEquals(0, person.getId());
		
		person = pr.save(person);
		System.out.println("person id" + person.getId());
		Assertions.assertNotEquals(0, person.getId());
				
	}
	
	@Test
	void getPerson() {
		Optional<Person> person = pr.findById(1);
		System.out.println(person);
		Assertions.assertFalse(person.isEmpty());
		
	}
	
	@Test
	void updatePerson() {
		Person person = pr.findById(1).get();
		person.setFirstname("updated first name");
		person.setLastname("updated last name");
		person.setPassword("updated password");
		pr.save(person);
		Person person2 = pr.findById(1).get();
		Assertions.assertEquals(person2, person);
	}
	
	@Test
	void deletePerson() {		
		Optional<Person> person = pr.findById(4);
		pr.deleteById(4);
		Optional<Person> person2 = pr.findById(4);
		System.out.println("this" + person);
		Assertions.assertNotEquals(person2, person);
		
	}
	
	@Test
	void getPersonByFirstLastName() {
		Person person = pr.findDistinctByLastnameAndFirstname("Molina", "Kim");
		Assertions.assertEquals("Kim", person.getFirstname());
		Assertions.assertEquals("Molina", person.getLastname());
	}
	
	@Test
	void getPersonByTitle() {
		List<Person> person = pr.findByTitle("buyer");
		Person person2 = person.get(1);
		System.out.println("person "+person2);
		Assertions.assertEquals("buyer", person2.getTitle());
	}
	
	@Test
	void getPersonByEmail() {
		Person person = pr.findDistinctByEmail("shunt@gmail.com");
		Assertions.assertEquals("shunt@gmail.com", person.getemail());
	}
}
