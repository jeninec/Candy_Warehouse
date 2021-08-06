package com.revature.services;

import java.util.List;

import com.revature.models.Person;

public interface PersonService {

	public Person addPerson(Person p);
	
	public Person getPerson(int id);
	
	public List<Person> getAllPersons();
	
	public Person updatePerson(Person change);
	
	public boolean deletePerson(int id);

	public Person getPersonByName(String lastName, String firstName);
	
	public Person getPersonByEmail(String email);
	
	public List<Person> getPersonsByTitle(String title);
}
