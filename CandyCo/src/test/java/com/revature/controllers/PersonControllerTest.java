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
import com.revature.models.Order;
import com.revature.models.Person;
import com.revature.services.PersonService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.app.CandyCompanyApplication.class)
public class PersonControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	PersonService ps;
	
	@Test
	void getPersonById() throws Exception {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person("Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.when(ps.getPerson(1)).thenReturn(person);
		
		ResultActions ra = mvc.perform(get("/people/1"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void getAllPeople() throws Exception{
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		List<Person> personList = new ArrayList<Person>();
		personList.add(person);
		
		Mockito.when(ps.getAllPersons()).thenReturn(personList);
		
		ResultActions ra = mvc.perform(get("/people"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void getPersonByName() throws Exception{
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "Heeoleh", "WAAAAA", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.when(ps.getPersonByName("Hah", "Hoo")).thenReturn(person);
		
		ResultActions ra = mvc.perform(get("/people/search-name")
				.param("fname", "Hoo").param("lname", "Hah"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void getPersonByEmail() throws Exception{
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "password", "email@email.email", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.when(ps.getPersonByEmail("email@email.email")).thenReturn(person);
		
		ResultActions ra = mvc.perform(get("/people/search-email")
				.param("email", "email@email.email"));
		ra.andExpect(status().isOk());	
	}
	
	@Test
	void getPersonsByTitle() throws Exception {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "password", "email@email.email", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		List<Person> pList = new ArrayList<Person>();
		pList.add(person);
		
		Mockito.when(ps.getPersonsByTitle("average")).thenReturn(pList);
		
		ResultActions ra = mvc.perform(get("/people/search-title")
				.param("title", "average"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void addPerson() throws Exception {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "password", "email@email.email", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.when(ps.addPerson(person)).thenReturn(person);
		
		ResultActions ra = mvc.perform(post("/people")
				  .content(asJsonString(person))
				  .contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON));
		ra.andExpect(status().isOk());
	}

	@Test
	void updatePerson() throws Exception {
		List<Order> oList = new ArrayList<Order>();
		Person person = new Person(1, "Hoo", "Hah", "password", "email@email.email", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Person person1 = new Person(1, "HooUpdated", "Hah", "password", "email@email.email", "KAAAAAA", "BAAAAAAA",
				"LEEEEEEE", "BOOOOOOO", "09843", "877-393-4448", "average", oList);
		
		Mockito.when(ps.updatePerson(person)).thenReturn(person1);
	
		ResultActions ra = mvc.perform(put("/people/1")
				  .content(asJsonString(person1))
				  .contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void deletePerson() throws Exception{
		Mockito.when(ps.deletePerson(1)).thenReturn(true);
	
		
		ResultActions ra = mvc.perform(delete("/people/1"));
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
