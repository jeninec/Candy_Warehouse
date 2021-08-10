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

import com.revature.models.*;
import com.revature.repositories.PersonRepo;

@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
public class PersonServiceTest {

	@Autowired
	PersonService ps;
	
	@MockBean
	PersonRepo pr;
	
	@Test
	void addPerson() {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person("Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.when(pr.save(person)).thenReturn(new Person(1, "Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList));
		
		person = ps.addPerson(person);
		
		Assertions.assertEquals(1, person.getId());
		Assertions.assertEquals("Hoo", person.getFirstname());
	}
	
	@Test
	void getPerson() {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		Optional<Person> optionP = Optional.of(person);
		
		Mockito.when(pr.findById(person.getId())).thenReturn(optionP);
		
		Assertions.assertEquals(1, optionP.get().getId());
	}
	
	@Test
	void getAllPeople() {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		List<Person> personList = new ArrayList<Person>();
		personList.add(person);		
		
		Mockito.when(pr.findAll()).thenReturn(personList);
		
		personList = ps.getAllPersons();
		
		Assertions.assertNotNull(personList);
	}
	
	@Test
	void updatePerson() {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Person person1 = new Person(1, "HooUpdated", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.when(pr.save(person1)).thenReturn(new Person(1, "HooUpdated", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList));
	
		person = ps.updatePerson(person1);
		
		Assertions.assertEquals("HooUpdated", person.getFirstname());
	}
	
	@Test
	void deletePerson() {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.doThrow(IllegalArgumentException.class).when(pr).deleteById(person.getId());
		
		boolean ret = ps.deletePerson(person.getId());
		Assertions.assertFalse(ret);
	}
	
	
}
