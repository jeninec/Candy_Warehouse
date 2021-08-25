package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Person;
import com.revature.services.PersonService;



@RestController
public class PersonController {

	@Autowired
	PersonService ps;
	
	@CrossOrigin
	@GetMapping(value = "/people", produces = "application/json")
	public List<Person> getAllItems(){
		return ps.getAllPersons();
	}
	
	@CrossOrigin
	@GetMapping("people/{id}")
	public Person getPerson(@PathVariable("id") String id) {
		return ps.getPerson(Integer.parseInt(id));
		
	}
	
	@CrossOrigin
	@GetMapping("people/search-name")
	public Person getPersonByName(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName){
		return ps.getPersonByName(lastName, firstName);
	}
	
	@CrossOrigin
	@GetMapping("people/search-email")
	public Person getPersonByEmail(@RequestParam("email") String email){
		return ps.getPersonByEmail(email);
	}
	
	@CrossOrigin
	@GetMapping("people/search-title")
	public List<Person> getPersonsByTitle(@RequestParam("title") String title){
		return ps.getPersonsByTitle(title);
	}
	
	@CrossOrigin
	@PostMapping(value = "/people", consumes = "application/json", produces = "application/json")
	public Person addPerson(@RequestBody Person p) {
		return ps.addPerson(p);
	}
	
	@CrossOrigin
	@PutMapping(value = "/people/{id}", consumes = "application/json", produces = "application/json")
	public Person updatePerson(@PathVariable int id, @RequestBody Person change) {
		change.setId(id);
		return ps.updatePerson(change);
	}
	
	@CrossOrigin
	@DeleteMapping("/people/{id}")
	public boolean deletePerson(@PathVariable int id) {
		return ps.deletePerson(id);
	}
}
