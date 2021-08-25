package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.revature.models.Person;


@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
@Transactional
public class PersonRepoTests {


	@Autowired
	public PersonRepo pr;
	
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
